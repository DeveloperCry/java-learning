package learning.springboot.service.impl;

import learning.springboot.entity.User;
import learning.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private User user;

    @Override
    public String getUserName() {

        return user.getName();
    }
}
