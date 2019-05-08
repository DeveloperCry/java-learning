/**
 * 
 */
package com.learning.jvm.reloadAndGC;

/**
 * @author Xiong.Liu
 *
 */
public class UserDao {
    private User user;
    
    public String getUserName(){
        //关键操作，运行main方法后切换下面方法，编译后下一次调用生效
        return user.getName();
//        return user.getFullName();
    }
    public void setUser(User user) {
        this.user = user;
    }

}
