package cn.skill6.website.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/** mybatis示例注解方式示例 */
@Mapper
public interface TestModelDao {
  @Delete("DELETE test_model WHERE ID = #{id}")
  int deleteTestModelById(int id);
}
