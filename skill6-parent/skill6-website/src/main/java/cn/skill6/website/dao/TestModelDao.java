package cn.skill6.website.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestModelDao {

  /**
   * @param id
   * @return
   */
  @Delete("DELETE test_model WHERE ID = #{id}")
  int deleteTestModelById(int id);
}
