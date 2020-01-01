package learning.builder.support;

import learning.builder.CarBuilder;

public class LuxuryCarBuilder extends CarBuilder {
    @Override
    public void engine() {
        super.car.setEngine("V8缸发动机");
    }

    @Override
    public void gearbox() {
        super.car.setGearbox("法拉利变数箱");
    }

    @Override
    public void chassis() {
        super.car.setChassis("承载式底盘");
    }
}
