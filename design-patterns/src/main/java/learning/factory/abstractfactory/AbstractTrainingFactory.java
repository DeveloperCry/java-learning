package learning.factory.abstractfactory;

/**
 * 抽象工厂模式(主要解决产品族的问题，在产品族扩展上很方便)
 * 这样的工厂模式对于数量不多的话，还是比较好的，要添加一种书，只用再添加实现类和相应的工厂类
 */
public abstract class AbstractTrainingFactory {
    public abstract <T extends Company> T createCompany();
    public abstract <T extends Book> T createBooK();
    public abstract <T extends Course> T createCourse();
}
