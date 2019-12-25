package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.Mediator;

/**
 * 传感器
 */
public class Sensor extends Device {
    public Sensor(Mediator mediator) {
        super(mediator);
    }

    public void open() {
        System.out.println("打开传感器。。。");
    }

    public void close() {
        System.out.println("关闭传感器。。。");
    }

    public void breakIn() {
        System.out.println("非法闯入");
        super.mediator.sendMessage("有人非法闯入");
    }
}
