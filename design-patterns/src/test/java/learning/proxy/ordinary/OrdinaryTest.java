package learning.proxy.ordinary;

import org.junit.Test;

public class OrdinaryTest {

    @Test
    public void testOrdinary() {
        Bank bank = new BankTeller();
        bank = new Proxy(bank);
        bank.drawMoney();
        bank.saveMoney();
    }
}
