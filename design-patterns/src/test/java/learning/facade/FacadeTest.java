package learning.facade;

import org.junit.Test;

public class FacadeTest {
    @Test
    public void testFacade() {
        Facade facade = new Facade();
        facade.doContext();
        facade.manager();
        facade.personnel();
    }

    @Test
    public void testSuperFacade() {
        SuperFacade superFacade = new SuperFacade();
        superFacade.doSomething();
    }
}
