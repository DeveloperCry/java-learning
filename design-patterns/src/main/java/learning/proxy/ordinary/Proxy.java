package learning.proxy.ordinary;

/**
 * 这是一个普通代理
 *
 * 这里构造函数传入一个bank，这样的话，就可以想代理谁就代理谁，还可以多重代理
 */
public class Proxy implements Bank {
    private Bank bank;

    public Proxy(Bank bank) {
        this.bank = bank;
    }

    public void before() {
        System.out.println("请出示银行卡并输入密码");
    }

    public void afterSaveMoney() {
        System.out.println("请收好您的钱和银行卡");
    }

    public void afterDrawMoney() {
        System.out.println("谢谢光临，请收好你的银行卡");
    }

    @Override
    public void drawMoney() {
        this.before();
        this.bank.drawMoney();
        this.afterSaveMoney();
    }

    @Override
    public void saveMoney() {
        this.before();
        this.bank.saveMoney();
        this.afterDrawMoney();
    }
}
