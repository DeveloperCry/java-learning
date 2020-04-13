package com.learning.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learning.demo.entity.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoleDao extends BaseMapper<Role> {

//    IPage<User> selectUserPage(@Param("page") IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
}
