package com.learning.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.learning.demo.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccountDao extends BaseMapper<Account> {

//    IPage<User> selectUserPage(@Param("page") IPage<User> page, @Param(Constants.WRAPPER) Wrapper<User> queryWrapper);
}
