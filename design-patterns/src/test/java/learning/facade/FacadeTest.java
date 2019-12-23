package learning.facade;

import org.junit.Test;

public class FacadeTest {
    @Test
    public void testFacade() {
        Facade facade = new Facade();
        facade.maintain();
        facade.manager();
        facade.personnel();
    }
}
