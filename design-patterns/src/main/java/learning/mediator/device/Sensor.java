package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.DeviceType;
import learning.mediator.Mediator;
import learning.mediator.OptionType;

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
        super.option(DeviceType.ALERTOR, OptionType.ALARM.getOption());
        super.option(DeviceType.CAMERA, OptionType.SHOOT.getOption());
        super.option(DeviceType.PHONE, OptionType.ACCEPT_MESSAGE.getOption(), "有人非法闯入");
    }
}
