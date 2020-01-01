package learning.bridge;

/**
 * 这个类就有点类似桥梁
 *
 * 核心：将抽象和实现解耦，使得两者可以独立地变化(抽象角色引用实现角色，或者说抽象角色的部分实现是由实现角色完成的)
 *
 * 使用的重点是要分析系统，是否是需要抽象和实现分开
 *
 * 有点类似组合，不同的组合将得到不同的结果。但是注意的是一点要选对何为抽象，何为实现。如品牌为实现，样式为抽象；再比如这个例子，
 * 肉类为实现，烹饪为抽象。
 */
public abstract class Cook {
    protected Meat meat;

    public Cook(Meat meat) {
        this.meat = meat;
    }

    public abstract void cut();
    public abstract void cookingTime();
}
