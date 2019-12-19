package learning.singleton;

/**
 * 枚举类
 * 线程安全
 *
 * 所有的枚举类型隐性地继承自java.lang.Enum 。
 * 枚举实质上还是类！而每个枚举的成员实质就是一个枚举类型的实例，
 * 这里序列化的时候只将 SINGLETON 这个名称输出，反序列化的时候再通过这个名称，查找对于的枚举类型，因此反序列化后的实例也会和之前被序列化的对象实例相同
 */
public enum Singleton08 {
    SINGLETON;
}
