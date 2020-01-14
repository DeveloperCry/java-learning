/**
 * 
 */
package learning.mode.mediator2;

/**
 * @author Xiong.Liu
 *
 */
public class ConcreteColleague2 extends AbstractColleague {

    //通过构造函数传递中介者
    public ConcreteColleague2(AbstractMediator _mediator){
        super(_mediator);
    }
    //自有方法 self-method
    public void selfMethod2(){
        //处理自己的业务逻辑
        System.out.println("This is concrete colleague2 self method1");
    }
    //依赖方法 dep-method
    public void depMethod2(){
        //处理自己的业务逻辑
        //自己不能处理的业务逻辑，委托给中介者处理
        super.mediator.doSomething2();
    }

}
