package cn.skill6.website.security.realm.auth;

import cn.skill6.common.entity.enums.LoginType;
import cn.skill6.common.entity.enums.UserState;
import cn.skill6.common.entity.po.rbac.RbacPermissionInfo;
import cn.skill6.common.entity.po.rbac.RbacRoleInfo;
import cn.skill6.common.entity.po.user.UserInfo;
import cn.skill6.website.dao.intf.rbac.RbacRoleDao;
import cn.skill6.website.dao.intf.user.UserDao;
import cn.skill6.website.security.realm.Skill6Realm;
import cn.skill6.website.security.token.AccountPasswordTypeToken;
import cn.skill6.website.util.ByteSourceSerializable;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户名+密码登录
 *
 * @author 何明胜
 * @version 1.2
 * @since 2018年10月23日 上午12:06:27
 */
@Slf4j
@Repository
public class UserNameRealm extends Skill6Realm {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RbacRoleDao rbacRoleDao;

    /**
     * 仅支持用户名密码方式登录
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        log.debug("access UserNameRealm.supports()");
        AccountPasswordTypeToken typeToken = (AccountPasswordTypeToken) token;

        return LoginType.USERNAME == typeToken.getLoginType();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 根据用户名查询当前用户拥有的角色
        List<RbacRoleInfo> roleInfos = userDao.findRolesByUserName(userName);

        // 将角色名称提供给info
        Set<String> roleNames =
                roleInfos.stream().map(RbacRoleInfo::getRoleName).collect(Collectors.toSet());
        authorizationInfo.setRoles(roleNames);
        log.info("获取当前所有角色：" + authorizationInfo.getRoles());

        // 根据用户名查询当前用户权限
        List<Long> roleIds = roleInfos.stream().map(RbacRoleInfo::getRoleId).collect(Collectors.toList());
        List<RbacPermissionInfo> permissionInfos = rbacRoleDao.findPermissionByRoleIds(roleIds);

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
        String userName = (String) token.getPrincipal();
        UserInfo user = userDao.findUserByUserName(userName);

        // 没找到帐号
        if (user == null) {
            throw new UnknownAccountException();
        }

        // 帐号锁定
        if (UserState.LOCKED == user.getUserState()) {
            throw new LockedAccountException();
        }

        // salt=salt@username
        String salt = StringUtils.join(user.getUserPwdSalt(), "@", user.getUserName());
        ByteSourceSerializable saltByteSource = new ByteSourceSerializable(salt);

        // 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配. 用户名, 密码, salt, realm name
        return new SimpleAuthenticationInfo(
                user.getUserName(), user.getUserPassword(), saltByteSource, getName());
    }
}
