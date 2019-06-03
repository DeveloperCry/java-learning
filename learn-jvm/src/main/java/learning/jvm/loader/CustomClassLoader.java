/**
 * 
 */
package learning.jvm.loader;

import java.io.FileInputStream;

/**
 * @author Xiong.Liu
 *
 */
public class CustomClassLoader extends ClassLoader{
    private String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    //自定义类加载器继承了ClassLoader，称为一个可以加载类的加载器，同时覆盖了loadClass方法，实现自己的逻辑
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        //排除掉加载系统默认需要加载的内心类，因为些类只能又默认类加载器去加载，第三方加载会抛异常，具体原因下文解释
        if(!name.contains("java.lang")){
            byte[] data = new byte[0];
            try {
                data = this.loadByte(name);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return defineClass(name, data, 0, data.length);
        }else{
            return super.loadClass(name);
        }
    }
    
    //把影片的二进制类文件读入内存字节流
    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        String dir = classPath + "/" + name + ".class";
        FileInputStream fis = new FileInputStream(dir);
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

    

}
