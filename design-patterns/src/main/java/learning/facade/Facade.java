package learning.facade;

import learning.facade.inner.Administration;
import learning.facade.inner.Context;
import learning.facade.inner.HumanResource;
import learning.facade.inner.TechnicalDivision;

/**
 * 门面模式就是当找到门面的时候，我只管我要做的事情，至于门面去找谁(对象)我不管，我只找你门面，剩下的我不管了
 *
 * 这个模式有个不好之处在于它不符合开闭原则，因为要扩展就得修改门面类
 *
 * 场景:
 * 为一个复杂的模块或子系统提供一个供外界访问的接口
 * 子系统相对独立
 * 预防低水平人员带来的风险扩散预防低水平人员带来的风险扩散
 *
 * 其实MVC中VC就是一个很好的门面的应用
 */
public class Facade {
    private Administration administration = new Administration();
    private HumanResource humanResource = new HumanResource();
    private Context context = new Context();

    public void manager() {
        this.administration.manager();
    }

    public void personnel() {
        this.humanResource.personnel();
    }

    public void doContext() {
        this.context.doContext();
    }
}
