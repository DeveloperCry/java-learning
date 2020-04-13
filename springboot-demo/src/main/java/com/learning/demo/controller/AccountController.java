package com.learning.demo.controller;

import com.learning.demo.dto.acc.ResetPasswordDto;
import com.learning.demo.entity.Account;
import com.learning.demo.plugins.PageInfo;
import com.learning.demo.response.ResponseSummary;
import com.learning.demo.response.StatusCode;
import com.learning.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/acc")
public class AccountController {

    @Autowired
    private AccountService accSrv;

    @GetMapping("/list")
    public String list(ModelMap map, @RequestParam(defaultValue = "1") Long pageNum, @RequestParam(defaultValue = "10") Long pageSize) {
        PageInfo<Account> accountPage = new PageInfo<>();
        accountPage.setCurrent(pageNum);
        accountPage.setSize(pageSize);

        this.accSrv.page(accountPage);
        System.out.println("page cot:" + accountPage.getPages());
        map.addAttribute("accPage", accountPage);

        return "acc/list";
    }

    @GetMapping("/profile/{id}")
    public String getProfile(ModelMap map, @PathVariable Long id) {
        Account account = accSrv.getById(id);
        map.addAttribute("profile", account);
        return "acc/profile";
    }

    @GetMapping("/resetPassword")
    public String getResetPassword() {
        return "acc/resetPassword";
    }

    @PostMapping("/resetPassword/{id}")
    @ResponseBody
    public ResponseSummary postResetPassword( @PathVariable Long id, ResetPasswordDto dto) {
        boolean success = this.accSrv.resetPassword(id, dto);
        if (success) {
            return ResponseSummary.SUCCESS();
        } else {
            return ResponseSummary.createSummary(StatusCode.USER_REST_PASSWORD_FAIL);
        }
    }

}
