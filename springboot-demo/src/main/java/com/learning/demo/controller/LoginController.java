package com.learning.demo.controller;

import com.learning.demo.constants.Constant;
import com.learning.demo.entity.Account;
import com.learning.demo.response.ResponseSummary;
import com.learning.demo.response.StatusCode;
import com.learning.demo.service.AccountService;
import com.learning.demo.dto.LoginDto;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private AccountService userService;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("login")
    @ResponseBody
    public ResponseSummary postLogin(HttpServletRequest request, @RequestBody LoginDto loginDto) {
        if (loginDto == null) {
            return new ResponseSummary(StatusCode.USER_LOGIN_ERROR);
        }

        Account account = this.userService.loginAcc(loginDto);
        System.out.println(ToStringBuilder.reflectionToString(account));
        if (account == null) {
            return new ResponseSummary(StatusCode.USER_LOGIN_ERROR);
        } else {
            request.getSession().setAttribute(Constant.ACCOUNT_SESSION, account);
            String nextPage = "/index";

            return ResponseSummary.createSummary(StatusCode.USER_LOGIN_SUCCESS, nextPage);
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }
}
