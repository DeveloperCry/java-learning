/**
 * 
 */
package learning.mode.factory.simple;

/**
 * @author Xiong.Liu
 * （1）简单工厂模式
 * 当一个模块只需要一个工工厂类时，我们可以将抽象工厂类kill掉，然后将具体工厂类中制造产品的方法前面加static
 * 关键字，则，工厂方法模式就变为了简单工厂模式。
 * 该模式是工厂方法模式的弱化，因为简单，所以称为简单工厂模式（Simple Factory Pattern），也叫做静态工
 * 厂模式。在实际项目中，采用该方法的案例还是比较多的，其缺点是工厂类的扩展比较困难，不符合开闭原则，但它
 * 仍然是一个非常实用的设计模式。
 * 
 * 优点
 * 简单工厂模式的工厂类是整个模式的关键。其中包含了必要的逻辑判断，根据外部信息，决定究竟应该创建哪个具体类的对象。
 * 通过使用简单工厂模式，用户无需了解对象如何创建的，只要传入必要信息就可以了。
 * 缺点
 * 工厂类集中了所有实例的创建逻辑，违背了高内聚责任分配原则。
 * 随着系统中具体产品类不断增多，势必要不断修改工厂类，不易维护和扩展。同时，这也违背了开放封闭原则。
 */
public abstract class Creator {
	public abstract <T extends Vehicle> T createVehicle(Class<T> vehicleClass);
}
