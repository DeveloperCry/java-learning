package learning.prototype;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PrototypeTest {
    @Test
    public void testUser() {
        ArrayList<String> addresses = new ArrayList<>();
        addresses.add("成都市");

        User user = new User();
        user.setName("XXX");
        user.setAddresses(addresses);
        System.out.println("这是拷贝前的对象 " + user.hashCode());
        System.out.println("这是拷贝前的name " + user.getName());
        System.out.println("这是拷贝前的addresses " + user.getAddresses());

        User cloneUser = user.clone();
        cloneUser.setName("拷贝名称");
        cloneUser.getAddresses().add("北京市");
        Assert.assertNotNull(cloneUser);
        System.out.println("这是拷贝完成后的对象 " + cloneUser.hashCode());
        System.out.println("这是拷贝完成后的name " + cloneUser.getName());
        System.out.println("这是拷贝完成后的addresses " + cloneUser.getAddresses());

        System.out.println("这是拷贝完成后原来的name " + user.getName());
        System.out.println("这是拷贝完成后原来的addresses " + user.getAddresses());
    }
}
