package com.learning.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/index")
    public String index() {
        log.info("这是index方法。。。。。");
        return "index";
    }

    @GetMapping("/")
    public String defaultIndex() {
        return "index";
    }

}
