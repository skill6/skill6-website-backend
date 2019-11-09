package cn.skill6.website.dao.impl.basic;

import cn.skill6.common.entity.po.other.CategoryInfo;
import cn.skill6.common.exception.general.NullPointerException;
import cn.skill6.website.dao.intf.basic.CategoryDao;
import cn.skill6.website.dao.mappers.basic.CategoryInfoMapper;
import cn.skill6.website.util.sequence.SequenceManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 目录信息操作实现类
 *
 * @author 何明胜
 * @version 1.6
 * @since 2018年8月28日 上午12:17:33
 */
@Slf4j
@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private CategoryInfoMapper categoryInfoMapper;

    @Override
    public int deleteByCategoryId(Long categoryId) {
        log.warn("删除id为{}的目录", categoryId);

        return categoryInfoMapper.deleteByPrimaryKey(categoryId);
    }

    @Override
    public long addCategoryInfo(CategoryInfo categoryInfo) {
        long categoryId = SequenceManager.getNextId();
        categoryInfo.setCategoryId(categoryId);

        categoryInfo.setCategoryCreateTime(new Date());
        categoryInfo.setCategoryUpdateTime(new Date());
        categoryInfo.setCategoryValid(true);

        categoryInfoMapper.insert(categoryInfo);
        log.info("增加目录分类成功,{}", categoryInfo);

        return categoryId;
    }

    @Override
    public CategoryInfo findByCategoryId(Long categoryId) {
        CategoryInfo categoryInfo = categoryInfoMapper.selectByPrimaryKey(categoryId);
        log.info("找到id为{}的目录,{}", categoryId, categoryInfo);

        return categoryInfo;
    }

    @Override
    public List<CategoryInfo> findAll() {
        List<CategoryInfo> categoryInfos = categoryInfoMapper.selectAll();
        log.info("找到所有目录,{}", categoryInfos);

        return categoryInfos;
    }

    @Override
    public void modifyByCategoryId(CategoryInfo categoryInfo) {
        if (categoryInfo == null || categoryInfo.getCategoryId() == null) {
            throw new NullPointerException("目录或者目录id不能为空");
        }
        CategoryInfo categoryInfoNew = categoryInfoMapper.selectByPrimaryKey(categoryInfo.getCategoryId());

        if (StringUtils.isNotEmpty(categoryInfo.getCategoryName())) {
            categoryInfoNew.setCategoryName(categoryInfo.getCategoryName());
        }
        categoryInfoNew.setCategoryUpdateTime(new Date());

        categoryInfoMapper.updateByPrimaryKey(categoryInfoNew);
        log.info("成功修改id为{}的目录内容", categoryInfo.getCategoryId());
    }
}
