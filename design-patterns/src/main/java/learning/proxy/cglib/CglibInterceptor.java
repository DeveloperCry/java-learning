package learning.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 这个是一个cglib实现的动态代理。这里要实现cglib的拦截器
 */
public class CglibInterceptor implements MethodInterceptor {
    private Object object;

    public CglibInterceptor(Object object) {
        this.object = object;
    }

    public void before() {
        System.out.println("请出示银行卡并输入密码");
    }

    public void afterDrawMoney() {
        System.out.println("请收好您的钱和银行卡");
    }

    public void afterSaveMoney() {
        System.out.println("谢谢光临，请收好你的银行卡");
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        this.before();
        Object _obj = method.invoke(object, args);
        if (method.getName() == "drawMoney") {
            this.afterDrawMoney();
        } else if (method.getName() == "saveMoney") {
            this.afterSaveMoney();
        }
        return _obj;
    }
}
