package learning.cor;

/**
 * 使多个对象都有机会处理请求，从而避免了请求的发送者和接受者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理为止
 *
 * 在调用的时候我们可以将请求的链单独封装在一个类中
 *
 * 核心：就是将所有的处理类(Handler)设置成一个链状
 *
 * 缺点，要是处理类太多或是处理类本身就很耗时，这个时候就会比较耗时
 */
public abstract class Handler {
    protected Handler nextHandler;
    protected Level level;

    public Handler(Level level) {
        this.level = level;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract Response approve(Request request);
}
