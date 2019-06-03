/**
 * 
 */
package learning.mode.mediator2;

/**
 * @author Xiong.Liu
 *
 */
public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        AbstractMediator mediator = new ConcreteMediator();

        ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
        mediator.setC1(colleague1);
        ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);
        mediator.setC2(colleague2);
        
        colleague1.depMethod1();

        System.out.println("=========================");
        
        colleague2.depMethod2();

    }

}
