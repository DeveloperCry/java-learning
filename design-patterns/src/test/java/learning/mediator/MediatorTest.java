package learning.mediator;

import learning.mediator.device.*;
import org.junit.Test;

public class MediatorTest {

    @Test
    public void testMediator() {
        Mediator mediator = new ConcreteMediator();
        mediator.register(new TV(mediator));
        mediator.register(new Phone(mediator));
        mediator.register(new Alertor(mediator));
        mediator.register(new Camera(mediator));
        mediator.register(new Sensor(mediator));

        System.out.println("主人离家=============");
        mediator.leaveHome();
        System.out.println("\n非法闯入=============");
        mediator.breakIn();
        System.out.println("\n主人回家=============");
        mediator.backHome();
    }
}
