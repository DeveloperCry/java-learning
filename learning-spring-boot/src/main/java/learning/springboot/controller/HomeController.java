package learning.springboot.controller;

import learning.springboot.config.AppConfig;
import learning.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private AppConfig appConfig;
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {

        return appConfig.getMessage() + userService.getUserName();
    }
}
