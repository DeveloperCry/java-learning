/**
 * 
 */
package com.learning.jvm.reloadAndGC;

/**
 * @author Xiong.Liu
 *
 */
public class UserService {
    private UserDao userDao;
    
    public String getUserMessage(){
        return userDao.getUserName();
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
