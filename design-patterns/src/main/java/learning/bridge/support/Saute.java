package learning.bridge.support;

import learning.bridge.Cook;
import learning.bridge.Meat;

public class Saute extends Cook {
    public Saute(Meat meat) {
        super(meat);
    }

    @Override
    public void cut() {
        System.out.println("切丝耗费时间：" + super.meat.getWeight() * super.meat.getHardness() * 10);
    }

    @Override
    public void cookingTime() {
        System.out.println("炒菜耗费的时间：" + super.meat.getWeight() * super.meat.getHardness());
    }
}
