package learning.command.app;

import learning.command.App;

public class CameraApp implements App {

    @Override
    public void open() {
        System.out.println("打开摄像头");
    }

    @Override
    public void close() {
        System.out.println("关闭摄像头");
    }
}
