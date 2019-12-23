package learning.facade;

import learning.facade.inner.Administration;
import learning.facade.inner.Context;
import learning.facade.inner.HumanResource;

/**
 * 门面模式就是将一系列子系统封装起来，内部的运行逻辑不管，我只用调用门面的方法即可
 */
public class SuperFacade {
    private Administration administration = new Administration();
    private HumanResource humanResource = new HumanResource();
    private Context context = new Context();

    public void doSomething() {
        this.context.doContext();
        this.administration.manager();
        this.humanResource.personnel();
    }
}
