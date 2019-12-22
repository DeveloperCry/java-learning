package learning.prototype;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * 实际上就是一个浅拷贝(注意与深拷贝的区别)，如果这里面含有对象eg：list将不会对其拷贝，还是指向的是原来的对象的地址
 *
 * 用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象(不通过new关键字来产生一个对象，而是通过对象复制来实现的模式)
 *
 * 使用场景：
 * 资源优化：类初始化需要消化非常多的资源，包括数据、硬件资源等
 * 性能和安全要求的场景：通过new产生一个对象需要非常繁琐的数据准备和访问权限，则可以使用原型模式
 * 一个对象多个修改者的场景： 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用
 */
@Data
public class User implements Cloneable{
    private String name;
    private String email;
    private short age;
    private ArrayList<String> addresses;

    @Override
    protected User clone() {
        User user = null;
        try {
            user = (User) super.clone();
            this.addresses = (ArrayList<String>) this.addresses.clone(); //实现深拷贝
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
