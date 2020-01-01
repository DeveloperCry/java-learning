package learning.builder;

/**
 * 将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示
 *
 * 核心思想就是将产品和其构建方法分开，构建过程的顺序由指挥者来控制
 *
 * 注意，构建者模式适用于有共同属性的产品
 *
 * 该模式符合开闭原则，即增加产品的构建只用增加其构建方法就可以了
 *
 * 和工厂模式不一样的是，工厂模式是直接生产产品，而建造者模式注重的是构建方法和过程
 */
public abstract class CarBuilder {
    protected Car car = new Car();
    public abstract void engine();
    public abstract void gearbox();
    public abstract void chassis();

    public Car build() {
        return this.car;
    }
}
