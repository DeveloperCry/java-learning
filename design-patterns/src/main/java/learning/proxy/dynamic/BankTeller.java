package learning.proxy.dynamic;

public class BankTeller implements Bank {

    @Override
    public void drawMoney() {
        System.out.println("将钱从保险柜中取出");
    }

    @Override
    public void saveMoney() {
        System.out.println("将钱放入保险柜");
    }
}
