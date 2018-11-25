package cn.skill6.website.dao.mappers.thirdparty;

import java.util.List;

import cn.skill6.common.entity.po.thirdparty.ThirdpartyAuth;

/**
 * 第三方授权mapper
 *
 * @author 何明胜
 * @version 1.1
 * @since 2018年11月1日 下午11:42:39
 */
public interface ThirdpartyAuthMapper {

  int deleteByPrimaryKey(Long thirdpartyId);

  int insert(ThirdpartyAuth thirdpartyAuth);

  ThirdpartyAuth selectByPrimaryKey(Long thirdpartyId);

  List<ThirdpartyAuth> selectAll();

  int updateByPrimaryKey(ThirdpartyAuth thirdpartyAuth);
  
  List<ThirdpartyAuth> selectByParams(ThirdpartyAuth thirdpartyAuth);
}
