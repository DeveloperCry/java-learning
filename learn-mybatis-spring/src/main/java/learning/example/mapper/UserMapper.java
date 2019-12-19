package learning.example.mapper;

import learning.example.enity.User;
import learning.example.enity.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @ResultMap(value = "UserMapper.BaseResultMap")//remove when using org.apache.ibatis.session.Configuration-mapUnderscoreToCamelCase
    @Select("SELECT * FROM USER WHERE ID = #{id}")
    public User getUser(Integer id);
}