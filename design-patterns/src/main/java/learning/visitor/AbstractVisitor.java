package learning.visitor;

import learning.visitor.house.BigHouse;
import learning.visitor.house.MiddleHouse;
import learning.visitor.house.SmallHouse;

/**
 * 抽象访问者
 *
 * 封装一些作用于某种数据结构的各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作
 *
 * 核心，分清楚哪些是不变的(如房子)，哪些是变的(如人)访问者
 *      数据结构(ObjectStructure)是可以存在的也是可以不用存在的
 *      在调用的时候一定是将访问者传入到被访问的accept方法中，在accept中还可以执行一些逻辑
 */
public abstract class AbstractVisitor {
    public abstract void callOnSmallHose(SmallHouse smallHouse);
    public abstract void callOnMiddleHose(MiddleHouse middleHouse);
    public abstract void callOnBigHose(BigHouse bigHouse);
}
