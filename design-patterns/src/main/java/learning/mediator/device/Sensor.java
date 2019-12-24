package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.DeviceType;
import learning.mediator.Mediator;

/**
 * 传感器
 */
public class Sensor extends Device {
    public Sensor(Mediator mediator) {
        super(mediator);
        mediator.register(DeviceType.SENSOR, this);
    }

    public void open() {
        System.out.println("打开传感器。。。");
    }

    public void close() {
        System.out.println("关闭传感器。。。");
    }

    public void breakIn() {
        System.out.println("非法闯入");
    }
}
