package learning.proxy.cglib;

import org.junit.Test;

public class CglibProxyTest {

    /**
     * 这种方式实现的动态代理使用起来不方便，因为每次都要调用Proxy.newProxyInstance()方法
     */
    @Test
    public void testCglibProxy() {
        BankTeller bankTeller = new BankTeller();
        BankTeller proxy = (BankTeller) CglibProxy.newProxyInstance(bankTeller);
        proxy.drawMoney();
        proxy.saveMoney();
    }
}
