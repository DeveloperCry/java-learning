package learning.flyweight;

import org.junit.Test;

public class FlyweightTest {
    @Test
    public void testFlyweight() {
        FlyweightFactory factory = new FlyweightFactory();
        Tank tank = factory.getTank("MT1");
        Troops troops = new Troops("美国特种部队");
        tank.drive(troops);

        Tank tank2 = factory.getTank("MT2");
        tank2.drive(troops);
    }
}
