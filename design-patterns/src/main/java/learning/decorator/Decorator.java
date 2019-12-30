package learning.decorator;

/**
 * 动态地给一个对象添加一个额外的职责。就增加功能来说，装饰模式相比生成子类更为灵活
 *
 * 其核心就是对原有的功能进行装饰，而且还可以无限的增强，同时也是可插拔式的，即如果不想用某个装饰了，直接删除即可
 *
 * 这个模式符合开闭原则
 *
 * 这个模式需要设计得很巧妙，这样的话就可以非常的灵活
 */
public abstract class Decorator extends Cook {
    protected Cook cook;

    public Decorator(Cook cook) {
        this.cook = cook;
    }
}
