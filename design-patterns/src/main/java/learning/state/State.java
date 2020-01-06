package learning.state;

/**
 * 状态模式：当一个对象内在状态改变时允许其改变行为，这个对象看起来像改变了其类。注意内在状态
 *
 * 这里还有一个比较重要的就是context，这个context包含了所有的状态
 *
 * 使用场景：
 *     行为随状态改变而改变的场景
 *     条件、分支判断语句的替代者
 *
 * 有个缺点就是子类会太多，所以在设计的时候得注意这一点
 *
 */
public abstract class State {
    protected Context context;

    public State(Context context) {
        this.context = context;
    }

    public abstract void render();
    public abstract boolean review();
    public abstract void publish();
}
