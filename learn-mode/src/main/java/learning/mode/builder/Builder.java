/**
 * 
 */
package learning.mode.builder;

/**
 * @author Xiong.Liu
 * 优点:
 * ● 封装性
 * ● 建造者独立，容易扩展
 * ● 便于控制细节风险
 * 使用场景:
 * ● 相同的方法，不同的执行顺序，产生不同的事件结果时，可以采用建造者模式。
 * ● 多个部件或零件，都可以装配到一个对象中，但是产生的运行结果又不相同时，则可以使用该模式。
 * ● 产品类非常复杂，或者产品类中的调用顺序不同产生了不同的效能，这个时候使用建造者模式非常合适。
 * ● 在对象创建过程中会使用到系统中的一些其他对象，这些对象在产品对象的创建过程中不易得到时，也可以采用建造者模式封装该对象的创建过程。
 * 该种场景只能是一个补偿方法，因为一个对象不容易获得，而在设计阶段竟然没有发觉，而要通过创建者模式柔化创建过程，本身已经违反设计的最初目标。
 */
public interface Builder {
	public void buildFoundation();
	public void buildWall();
    public void buildRoof();
    public void buildWindow();
    public void buildDoor();
    public House createHouse();
}
