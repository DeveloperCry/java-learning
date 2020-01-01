package learning.builder;

import learning.builder.support.CommonCarBuilder;
import learning.builder.support.LuxuryCarBuilder;
import org.junit.Test;

public class BuilderTest {
    @Test
    public void testBuilder() {
        CarBuilder commonCarBuilder= new CommonCarBuilder();
        Director director = new Director(commonCarBuilder);
        Car car = director.buildCar();
        System.out.println(car.toString());

        CarBuilder luxuryCarBuilder= new LuxuryCarBuilder();
        director = new Director(luxuryCarBuilder);
        car = director.buildCar();
        System.out.println(car.toString());
    }
}
