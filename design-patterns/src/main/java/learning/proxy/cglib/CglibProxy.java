package learning.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;


/**
 * 这个是一个cglib实现的动态代理。针对没有接口的类，给没有接口的类代理
 *
 * cglib 的实现原理就是实现继承要被代理的类(被代理的类不能是final的，必须满足可被继承的类)，这里的Enhancer就是关键，用来设置被继承的类
 */
public class CglibProxy {
    public static Object newProxyInstance(BankTeller bankTeller) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(BankTeller.class); //设置被代理的类
        enhancer.setCallback(new CglibInterceptor(bankTeller));//设置一个callback,以便调用方法
        return enhancer.create();
    }

}
