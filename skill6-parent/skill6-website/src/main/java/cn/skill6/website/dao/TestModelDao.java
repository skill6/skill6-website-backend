package cn.skill6.website.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * 你好
 *
 * @desc 你好
 * @author liujichun
 */
@Mapper
public interface TestModelDao {

  /**
   * @param id
   * @return
   */
  @Delete("DELETE test_model WHERE ID = #{id}")
  int deleteTestModelById(int id);
}
