package learning.bridge.support;

import learning.bridge.Cook;
import learning.bridge.Meat;

public class Stew extends Cook {
    public Stew(Meat meat) {
        super(meat);
    }

    @Override
    public void cut() {
        System.out.println("切块耗费时间：" + super.meat.getWeight() * super.meat.getHardness());
    }

    @Override
    public void cookingTime() {
        System.out.println("炖耗费的时间：" + super.meat.getWeight() * super.meat.getHardness() * 10);
    }
}
