package cn.skill6.website.dao.impl.thirdparty;

import cn.skill6.common.entity.po.PageSortParam;
import cn.skill6.common.entity.po.article.ArticleInfo;
import cn.skill6.common.entity.po.thirdparty.ThirdpartyAuth;
import cn.skill6.website.dao.intf.thirdparty.ThirdpartyAuthDao;
import cn.skill6.website.dao.mappers.thirdparty.ThirdpartyAuthMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 第三方授权操作实现
 *
 * @author 何明胜
 * @version 1.0
 * @since 2018年11月21日 下午11:15:30
 */
@Slf4j
@Repository
public class ThirdpartyAuthDaoImpl implements ThirdpartyAuthDao {

    @Autowired
    private ThirdpartyAuthMapper thirdpartyAuthMapper;

    @Override
    public void addThirdpartyAuth(ThirdpartyAuth thirdpartyAuth) {
        // 设置分布式用户id
        Long thirdpartyId = thirdpartyAuth.getThirdpartyId();
        if (thirdpartyId == null) {
            thirdpartyId = SequenceManager.getNextId();
            thirdpartyAuth.setThirdpartyId(thirdpartyId);
        }

        log.info("插入新的第三方授权数据, {}", thirdpartyAuth);

        thirdpartyAuthMapper.insert(thirdpartyAuth);
    }

    @Override
    public void deleteByThirdpartyId(Long thirdpartyId) {
        log.warn("根据id删除第三方授权数据, id为{}", thirdpartyId);

        thirdpartyAuthMapper.deleteByPrimaryKey(thirdpartyId);
    }

    @Override
    public ThirdpartyAuth findByThirdpartyId(Long thirdpartyId) {
        log.info("根据id查询第三方授权数据, id 为 {}", thirdpartyId);

        return thirdpartyAuthMapper.selectByPrimaryKey(thirdpartyId);
    }

    @Override
    public List<ThirdpartyAuth> findAll() {
        log.info("查询所有第三方授权数据");

        return thirdpartyAuthMapper.selectAll();
    }

    @Override
    public void updateByThirdpartyId(ThirdpartyAuth thirdpartyAuth) {
        log.info("更新第三方授权数据, {}", thirdpartyAuth);

        thirdpartyAuthMapper.updateByPrimaryKey(thirdpartyAuth);
    }

    @Override
    public List<ThirdpartyAuth> findByParams(ThirdpartyAuth thirdpartyAuth) {
        log.info("根据条件查询第三方授权数据, 条件为{}", thirdpartyAuth);

        List<ThirdpartyAuth> thirdpartyAuthList = thirdpartyAuthMapper.selectByParams(thirdpartyAuth);
        log.info("thirdpartyAuthList size：{}", thirdpartyAuthList.size());

        return thirdpartyAuthList;
    }

    @Override
    public List<ThirdpartyAuth> findByParamWithPage(ThirdpartyAuth thirdpartyAuth, PageSortParam pageSortParam) {
        log.info("根据条件查询第三方授权数据, 条件为{}", thirdpartyAuth);

        // 设置分页数据
        Page<ArticleInfo> page = PageHelper.startPage(pageSortParam.getPageNum(), pageSortParam.getPageSize());

        List<ThirdpartyAuth> thirdpartyAuthList = thirdpartyAuthMapper.selectByParams(thirdpartyAuth);
        log.info("找到数据数量：{}, 所有数据数量为：{}", thirdpartyAuthList.size(), page.getTotal());

        return thirdpartyAuthList;
    }
}
