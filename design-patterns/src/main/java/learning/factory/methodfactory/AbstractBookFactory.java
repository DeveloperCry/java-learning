package learning.factory.methodfactory;

/**
 * 工厂方法模式(主要解决单一产品的问题，在单一产品上扩展很方便)
 * 这样的工厂模式对于数量不多的话，还是比较好的，要添加一种书，只用再添加实现类和相应的工厂类
 */
public abstract class AbstractBookFactory {
    public abstract <T extends Book> T createBooK();
}
