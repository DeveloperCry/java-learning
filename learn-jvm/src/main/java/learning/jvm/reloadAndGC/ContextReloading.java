/**
 * 
 */
package learning.jvm.reloadAndGC;

import java.lang.reflect.InvocationTargetException;

import learning.jvm.loader.CustomClassLoader;

/**
 * @author Xiong.Liu
 *
 */
public class ContextReloading {
    /**
     * @param args
     * @throws IllegalAccessException 
     * @throws InvocationTargetException 
     * @throws NoSuchMethodException 
     * @throws InterruptedException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) 
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException, ClassNotFoundException, InstantiationException {
        while (true) {
            Object context = newContext();//创建应用上下文
            invokeContext(context);//通过上下文对象context调用业务方法
            Thread.sleep(5000);
        }

    }
    
    //创建应用的上下文，context是整个应用的GC roots，创建完返回对象之前调用init()初始化对象
    public static Object newContext()
        throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException,
        InvocationTargetException {
        String className = "Context";
        //通过自定义类加载器加载Context类
        CustomClassLoader classLoader = new CustomClassLoader("target/classes");
        Class<?> contextClass = classLoader.loadClass(className);
        Object context = contextClass.newInstance();//通过反射创建对象
        contextClass.getDeclaredMethod("init").invoke(context);//通过反射调用初始化方法init()
        return context;
    }
    //业务方法，调用context的业务方法showUser()
    public static void invokeContext(Object context)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String name = (String)context.getClass().getDeclaredMethod("showUser").invoke(context);
        System.out.println(name);
    }

}
