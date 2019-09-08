package cn.skill6.website.dao.intf.thirdparty;

import cn.skill6.common.entity.po.PageSortParam;
import cn.skill6.common.entity.po.thirdparty.ThirdpartyAuth;

import java.util.List;

/**
 * 第三方授权操作接口
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月21日 下午10:54:52
 */
public interface ThirdpartyAuthDao {
    void addThirdpartyAuth(ThirdpartyAuth thirdpartyAuth);

    void deleteByThirdpartyId(Long thirdpartyId);

    ThirdpartyAuth findByThirdpartyId(Long thirdpartyId);

    List<ThirdpartyAuth> findAll();

    void updateByThirdpartyId(ThirdpartyAuth thirdpartyAuth);

    List<ThirdpartyAuth> findByParams(ThirdpartyAuth thirdpartyAuth);

    public List<ThirdpartyAuth> findByParamWithPage(ThirdpartyAuth thirdpartyAuth, PageSortParam pageSortParam);
}
