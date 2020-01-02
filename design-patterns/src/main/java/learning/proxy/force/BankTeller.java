package learning.proxy.force;

public class BankTeller implements Bank {

    public BankTeller(Bank bank) throws Exception {
        if (bank == null) {
            throw new Exception();
        }
    }

    @Override
    public void drawMoney() {
        System.out.println("将钱从保险柜中取出");
    }

    @Override
    public void saveMoney() {
        System.out.println("将钱放入保险柜");
    }
}
