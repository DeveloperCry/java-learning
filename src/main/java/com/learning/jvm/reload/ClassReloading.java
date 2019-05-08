/**
 * 
 */
package com.learning.jvm.reload;

import java.lang.reflect.InvocationTargetException;

import com.learning.jvm.loader.CustomClassLoader;

/**
 * @author Xiong.Liu
 *
 */
public class ClassReloading {

    /**
     * @param args
     * @throws InstantiationException 
     * @throws SecurityException 
     * @throws NoSuchMethodException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws IllegalAccessException 
     * @throws ClassNotFoundException 
     * @throws InterruptedException 
     */
    public static void main(String[] args) 
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException, InterruptedException {
        while(true) { //用死循环让线程持续运行未中断状态
            //通过反射调用目标类的入口方法
            String className = "com.learning.jvm.reload.User";
            CustomClassLoader classLoader = new CustomClassLoader("target/classes");
            Class<?> target = classLoader.loadClass(className);
            System.out.println(target.getClassLoader());
            //加载进来的类，通过反射调用execute方法
            String option = (String)target.getDeclaredMethod("execute").invoke(target.newInstance());
            System.out.println(option);
            String sysOption = (String)User.class.getDeclaredMethod("execute").invoke(User.class.newInstance());
            System.out.println(sysOption);
            //如果换成系统默认类加载器的话，因为双亲委派原则，默认使用应用类加载器，而且能加载一次
            //休眠是为了在删除旧类编译新类的这段时间内不执行加载动作
            //不然会找不到类文件
            Thread.sleep(10000);
        }

    }

}
