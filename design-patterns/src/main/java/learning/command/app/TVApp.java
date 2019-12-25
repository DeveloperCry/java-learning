package learning.command.app;

import learning.command.App;

public class TVApp implements App {


    @Override
    public void open() {
        System.out.println("打开电视");
    }

    @Override
    public void close() {
        System.out.println("关闭电视");
    }
}
