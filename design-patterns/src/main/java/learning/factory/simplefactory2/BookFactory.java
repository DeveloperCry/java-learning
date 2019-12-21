package learning.factory.simplefactory2;

import java.lang.reflect.InvocationTargetException;

/**
 * 这个是第一种的变形，是通过java的反射来实现的
 * 这种工厂模式不利于工厂类的扩展，如果这个工厂类要生成别的东西，那就不得不修改该工厂类，不符合开闭原则
 * 同时由于没有接口，所以在新添加了类具体类的时候，调用者也改动大
 * 如果要写成静态的工厂方法，那么在每个方法前添加一个static即可
 */
public class BookFactory {
    public Book createBook(Class clazz) {
        //do something before
        Book book = null;
        try {
            book = (Book)Class.forName(clazz.getName()).getDeclaredConstructor().newInstance();//java9以后都是通过这种方式来实现反射的
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //do something after
        return book;
    }
}
