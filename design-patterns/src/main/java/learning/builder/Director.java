package learning.builder;

public class Director {
    private CarBuilder carBuilder;

    public Director(CarBuilder carBuilder) {
        this.carBuilder = carBuilder;
    }

    public Car buildCar() {
        this.carBuilder.engine();
        this.carBuilder.gearbox();
        this.carBuilder.chassis();
        return this.carBuilder.build();
    }
}
