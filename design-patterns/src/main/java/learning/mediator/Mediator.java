package learning.mediator;

/**
 * 我们以米家为例，所有的设备都连接到米家多功能网关中
 * 角色：
 *     网关(中介者)：核心类，执行相应的方法
 *     米家设备(同事类)：只知道自己的的行为，而不了解其他设备的行为，他们是相互独立的（核心思想）；但是他们都依赖中介者。
 *
 * 适用多个对象相互引用的场景
 * 核心思想就是同事类相互不影响，完全由中介者来调整，中介者就是核心，任何同事类要调用其他同事类的方法，都必须通过中介者
 *
 * 中介者模式的缺点就是对导致中介者类非常的庞大
 *
 * 门面模式和中介者模式之间的区别还是比较明显的，门面模式是以封装和隔离为主要任务，而中介者模式则是以调和同事类之间的关系为主，因为要调和，所以具有了部分的业务逻辑控制。两者的主要区别如下：
 *    功能区别
 *      门面模式只是增加了一个门面， 它对子系统来说没有增加任何的功能， 子系统若脱离门面模式是完全可以独立运行的。而中介者模式则增加了业务功能，它把各个同事类中的原有耦合关系移植到了中介者，同事类不可能脱离中介者而独立存在，除非是想增加系统的复杂性和降低扩展性。
 *    知晓状态不同
 *        对门面模式来说，子系统不知道有门面存在，而对中介者来说，每个同事类都知道中介者存在，因为要依靠中介者调和同事之间的关系，它们对中介者非常了解。
 *    封装程度不同
 *        门面模式是一种简单的封装，所有的请求处理都委托给子系统完成，而中介者模式则需要有一个中心，由中心协调同事类完成，并且中心本身也完成部分业务，它属于更进一步的业务功能封装。
 */
public abstract class Mediator {
    public abstract void register(Device device);
    public abstract void leaveHome();
    public abstract void breakIn();
    public abstract void backHome();
    public abstract void sendMessage(String message);
    public abstract void sendVideo(String video);
}
