/**
 * 
 */
package com.learning.jvm.principle;

import com.learning.jvm.loader.CustomClassLoader;

/**
 * @author Xiong.Liu
 *
 */
public class ClassIsolationPrinciple {

    public static void main(String[] args) {
        try {
            String className = "com.learning.jvm.principle.Demo"; //定义要加载类的全限定名
            Class<?> class1 = Demo.class;  //第一个类又系统默认类加载器加载
            //第二个类MyClassLoader为自定义类加载器，自定义的目的是覆盖加载类的逻辑
            CustomClassLoader classLoader = new CustomClassLoader("target/classes");
            Class<?> class2 = classLoader.loadClass(className);
            System.out.println("-----------------class name-----------------");
            System.out.println(class1.getName());
            System.out.println(class2.getName());
            System.out.println("-----------------classLoader name-----------------");
            System.out.println(class1.getClassLoader());
            System.out.println(class2.getClassLoader());
            Demo.example = 1;//这里修改的系统类加载器加载的那个类的对象，而自定义加载器加载进去的类的对象保持不变，也即是同时存在内存，但没有修改example的值。
            System.out.println("-----------------field value-----------------");
            System.out.println(class1.getDeclaredField("example").get(null));
            System.out.println(class2.getDeclaredField("example").get(null));
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
