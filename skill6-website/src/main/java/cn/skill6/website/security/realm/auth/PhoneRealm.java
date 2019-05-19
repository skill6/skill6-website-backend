package cn.skill6.website.security.realm.auth;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.skill6.common.entity.enums.LoginType;
import cn.skill6.common.entity.enums.UserState;
import cn.skill6.common.entity.po.rbac.RbacPermissionInfo;
import cn.skill6.common.entity.po.rbac.RbacRoleInfo;
import cn.skill6.common.entity.po.user.UserPrivacyInfo;
import cn.skill6.website.dao.intf.rbac.RbacRoleInfoDao;
import cn.skill6.website.dao.intf.user.UserPrivacyInfoDao;
import cn.skill6.website.security.realm.Skill6Realm;
import cn.skill6.website.security.token.AccountPasswordTypeToken;
import lombok.extern.slf4j.Slf4j;

/**
 * 手机验证码登录
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月1日 上午1:15:05
 */
@Slf4j
@Repository
public class PhoneRealm extends Skill6Realm {

  @Autowired private UserPrivacyInfoDao userPrivacyInfoDao;

  @Autowired private RbacRoleInfoDao rbacRoleInfoDao;

  /** 仅支持手机方式登录 */
  @Override
  public boolean supports(AuthenticationToken token) {
    log.debug("access UserNameRealm.supports()");
    AccountPasswordTypeToken typeToken = (AccountPasswordTypeToken) token;

    return LoginType.PHONE == typeToken.getLoginType();
  }

  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    String userPhone = (String) principals.getPrimaryPrincipal();
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

    // 根据用户名查询当前用户拥有的角色
    List<RbacRoleInfo> roleInfos = userPrivacyInfoDao.findRolesByUserPhone(userPhone);

    // 将角色名称提供给info
    Set<String> roleNames =
        roleInfos.stream().map(RbacRoleInfo::getRoleName).collect(Collectors.toSet());
    authorizationInfo.setRoles(roleNames);
    log.info("获取当前所有角色：" + authorizationInfo.getRoles());

    // 根据用户名查询当前用户权限
    List<Long> roleIds =
        roleInfos.stream().map(RbacRoleInfo::getRoleId).collect(Collectors.toList());
    List<RbacPermissionInfo> permissionInfos = rbacRoleInfoDao.findPermissionByRoleIds(roleIds);

    Set<String> permissionNames =
        permissionInfos
            .stream()
            .map(RbacPermissionInfo::getPermissionCode)
            .collect(Collectors.toSet());
    authorizationInfo.setRoles(permissionNames);

    // 将权限代码提供给info
    authorizationInfo.setStringPermissions(permissionNames);
    log.info("获取当前所有权限：" + authorizationInfo.getStringPermissions());

    return authorizationInfo;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    String userPhone = (String) token.getPrincipal();
    UserPrivacyInfo user = userPrivacyInfoDao.findUserByUserPhone(userPhone);

    // 没找到帐号
    if (user == null) {
      throw new UnknownAccountException();
    }

    // 帐号锁定
    if (UserState.LOCKED == user.getUserState()) {
      throw new LockedAccountException();
    }

    // salt=salt@username
    SimpleByteSource saltByteSource =
        new SimpleByteSource(StringUtils.join(user.getUserPwdSalt(), "@", user.getUserName()));

    // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配. 用户名, 密码, salt, realm name
    SimpleAuthenticationInfo authenticationInfo =
        new SimpleAuthenticationInfo(
            user.getUserName(), user.getUserPassword(), saltByteSource, getName());

    return authenticationInfo;
  }
}
