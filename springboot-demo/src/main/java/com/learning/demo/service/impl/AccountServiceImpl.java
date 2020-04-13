package com.learning.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learning.demo.dao.AccountDao;
import com.learning.demo.dto.acc.ResetPasswordDto;
import com.learning.demo.entity.Account;
import com.learning.demo.service.AccountService;
import com.learning.demo.dto.LoginDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Slf4j
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {

    @Override
    public boolean saveUser(Account user) {
        String password = user.getPassword();
//        user.setPassword(BPwdEncoderUtil.BCryptPassword(password));

        return this.save(user);
    }

    @Override
    public Account loginAcc(@NotNull LoginDto loginDto) {
        if (StringUtils.isBlank(loginDto.getUsername()) || StringUtils.isBlank(loginDto.getPassword())) {
            return null;
        }

        LambdaQueryWrapper<Account> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Account::getUsername, loginDto.getUsername())
                .eq(Account::getPassword, loginDto.getPassword());
        return this.getBaseMapper().selectOne(queryWrapper);
//        if (user != null) {
//            boolean isMatched = BPwdEncoderUtil.matches(loginDto.getPassword(), user.getPassword());
//        }
    }

    @Override
    public boolean resetPassword(Long id, ResetPasswordDto dto) {
        if (dto == null
                || id == null
                || StringUtils.isBlank(dto.getOldPassword())
                || StringUtils.isBlank(dto.getNewPassword())
                || !dto.getNewPassword().equals(dto.getConfirmNewPassword())) {
            return false;
        }

        Account account = this.getById(id);
        if (account.getPassword().equals(dto.getOldPassword())) {

            LambdaUpdateWrapper<Account> updateWrapper = new LambdaUpdateWrapper<>();
            //当设置为true的时候才是单个的设置值
            updateWrapper.set(true, Account::getPassword, dto.getNewPassword());
//            updateWrapper.eq() //这个是条件语句

            return this.update(updateWrapper);
        }

        return false;
    }
}
