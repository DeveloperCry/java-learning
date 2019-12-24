package learning.mediator;

import learning.mediator.device.*;
import org.junit.Test;

public class MediatorTest {

    @Test
    public void testMediator() {
        Mediator mediator = new ConcreteMediator();

        Phone phone = new Phone(mediator);
        Camera camera = new Camera(mediator);
        TV tv = new TV(mediator);
        Sensor sensor = new Sensor(mediator);
        Alertor alertor = new Alertor(mediator);

        phone.leaveHome();
    }
}
