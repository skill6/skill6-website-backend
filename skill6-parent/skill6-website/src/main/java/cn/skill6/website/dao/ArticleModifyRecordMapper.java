package cn.skill6.website.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.skill6.common.entity.po.ArticleModifyRecord;

public interface ArticleModifyRecordMapper {
    int deleteByPrimaryKey(@Param("articleId") Long articleId, @Param("articleLastModifyDate") Date articleLastModifyDate);

    int insert(ArticleModifyRecord record);

    ArticleModifyRecord selectByPrimaryKey(@Param("articleId") Long articleId, @Param("articleLastModifyDate") Date articleLastModifyDate);

    List<ArticleModifyRecord> selectAll();

    int updateByPrimaryKey(ArticleModifyRecord record);
}