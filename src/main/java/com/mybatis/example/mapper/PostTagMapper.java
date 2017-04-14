package com.mybatis.example.mapper;

import com.mybatis.example.enity.PostTag;
import com.mybatis.example.enity.PostTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostTagMapper {
    long countByExample(PostTagExample example);

    int deleteByExample(PostTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PostTag record);

    int insertSelective(PostTag record);

    List<PostTag> selectByExample(PostTagExample example);

    PostTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PostTag record, @Param("example") PostTagExample example);

    int updateByExample(@Param("record") PostTag record, @Param("example") PostTagExample example);

    int updateByPrimaryKeySelective(PostTag record);

    int updateByPrimaryKey(PostTag record);
}