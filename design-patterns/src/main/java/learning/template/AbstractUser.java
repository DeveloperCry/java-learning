package learning.template;

/**
 * 定义一个模板架构，然后让一些方法延迟到子类去实现，这个就是一个典型的多态的体现
 */
public abstract class AbstractUser {
    public void eat() {
        System.out.println("我是" + this.province() + ", 我喜欢吃" + this.food());
    }

    /**
     * 钩子函数
     * @return
     */
    protected abstract String province();
    protected abstract String food();
}
