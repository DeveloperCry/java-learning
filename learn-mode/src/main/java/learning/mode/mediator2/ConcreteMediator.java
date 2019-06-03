/**
 * 
 */
package learning.mode.mediator2;

/**
 * @author Xiong.Liu
 *
 */
public class ConcreteMediator extends AbstractMediator {

    @Override
    public void doSomething1() {
        //调用同事类的方法，只要是public方法都可以调用
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }
    public void doSomething2() {
        super.c1.selfMethod1();
        super.c2.selfMethod2();
    }

}
