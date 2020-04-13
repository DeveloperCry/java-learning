package com.learning.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.learning.demo.dto.acc.ResetPasswordDto;
import com.learning.demo.entity.Account;
import com.learning.demo.dto.LoginDto;

public interface AccountService extends IService<Account> {
    boolean saveUser(Account user);
    Account loginAcc(LoginDto loginDto);
    boolean resetPassword(Long id, ResetPasswordDto dto);
}
