package learning.proxy.dynamic;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {

    /**
     * 这种方式实现的动态代理使用起来不方便，因为每次都要调用Proxy.newProxyInstance()方法
     */
    @Test
    public void testDynamicProxy() {
        Bank bankTeller = new BankTeller();
        DynamicInvocationHandler handler = new DynamicInvocationHandler(bankTeller);
        Bank bank = (Bank) Proxy.newProxyInstance(bankTeller.getClass().getClassLoader(), bankTeller.getClass().getInterfaces(), handler);
        bank.drawMoney();
        bank.saveMoney();
    }

    @Test
    public void testDynamicProxy2() {
        Bank bankTeller = new BankTeller();
        Bank bank = DynamicProxy.newProxyInstance(bankTeller);
        bank.drawMoney();
        bank.saveMoney();
    }
}
