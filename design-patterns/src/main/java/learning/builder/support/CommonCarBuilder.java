package learning.builder.support;

import learning.builder.CarBuilder;

public class CommonCarBuilder extends CarBuilder {
    @Override
    public void engine() {
        super.car.setEngine("L4缸发动机");
    }

    @Override
    public void gearbox() {
        super.car.setGearbox("爱立信变数箱");
    }

    @Override
    public void chassis() {
        super.car.setChassis("承载式底盘");
    }
}
