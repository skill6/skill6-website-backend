package cn.skill6.website.dao.mappers.thirdparty;

import cn.skill6.common.entity.po.thirdparty.ThirdpartyAuth;
import java.util.List;

/**
 * 第三方授权mapper
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月1日 下午11:42:39
 */
public interface ThirdpartyAuthMapper {

  int insert(ThirdpartyAuth record);

  List<ThirdpartyAuth> selectAll();
}
