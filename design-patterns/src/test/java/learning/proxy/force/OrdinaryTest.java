package learning.proxy.force;

import org.junit.Test;

public class OrdinaryTest {

    @Test
    public void testOrdinary() throws Exception {
        Bank bank = new Proxy();
        bank.drawMoney();
        bank.saveMoney();
    }
}
