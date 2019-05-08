/**
 * 
 */
package com.learning.jvm.reloadAndGC;

/**
 * @author Xiong.Liu
 *
 */
public class Context {

    private UserService userService = new UserService();
    
    //初始化对象
    public void init(){
        UserDao userDao = new UserDao();
        userDao.setUser(new User());
        userService.setUserDao(userDao);
    }
    
    public String showUser(){
        return userService.getUserMessage();
    }

}
