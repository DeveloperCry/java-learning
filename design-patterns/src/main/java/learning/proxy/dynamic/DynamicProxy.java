package learning.proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * 这里运用的就是动态代理模式，动态代理模式的关键在于实现InvocationHandler接口
 *
 * 这个类是对代理的一个封装
 */
public class DynamicProxy {
    public static Bank newProxyInstance(Bank bank) {
        DynamicInvocationHandler handler = new DynamicInvocationHandler(bank);
        return (Bank)Proxy.newProxyInstance(bank.getClass().getClassLoader(), bank.getClass().getInterfaces(), handler);
    }

}
