package learning.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 这个类是实现InvocationHandler中的invoke方法，我们可以创建很多的InvocationHandler，例如：关于日志的，关于事务的等等，这个类才是动态代理的核心
 *
 * 实现动态代理的前提是必须有接口，没有接口就不能使用动态代理，Spring的AOP就是这样的，在有接口的情况下使用的是java的动态代理，没有接口的话使用的就是GILB来实现代理
 *
 * 代理和被代理对象都将实现同一个接口
 *
 * 代理的思想就是在将真正的实现转由代理来实现，被代理对象的逻辑不变，知识加了一些额外的功能
 *
 * 代理VS装饰
 *    代理模式着重对代理过程的控制
 *    装饰模式是代理模式的一种特殊应用，但是它着重的是对类的功能进行加强或减弱，它着重类的功能变化，例如，在学生看到升级表单后，将每一科目的成绩都加10等等
 */
public class DynamicInvocationHandler implements InvocationHandler {
    private Object object;

    public DynamicInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.before();
        Object _obj = method.invoke(object, args);
        if (method.getName() == "drawMoney") {
            this.afterDrawMoney();
        } else if (method.getName() == "saveMoney") {
            this.afterSaveMoney();
        }
        return _obj;
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
}
