package learning.flyweight;

public class Tank extends Flyweight {
    public Tank(String model) {
        super(model);
    }

    @Override
    public void drive(Troops troops) {
        System.out.println(troops.getName() + "拥有坦克型号是：" + super.model);
    }
}
