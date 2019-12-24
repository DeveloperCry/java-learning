package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.DeviceType;
import learning.mediator.Mediator;

public class Phone extends Device {
    public Phone(Mediator mediator) {
        super(mediator);
        mediator.register(DeviceType.PHONE, this);
    }

    public void acceptVideo(String video) {
        System.out.println("我接收到的视频是 " + video);
    }

    public void leaveHome() {
        System.out.println("我离开家了");
        super.option(DeviceType.CAMERA, "open");
        super.option(DeviceType.ALERTOR, "open");
        super.option(DeviceType.SENSOR, "open");
        super.option(DeviceType.TV, "close");
    }

    public void backHome() {
        System.out.println("我回家了");
        super.option(DeviceType.CAMERA, "close");
        super.option(DeviceType.ALERTOR, "close");
        super.option(DeviceType.SENSOR, "close");
        super.option(DeviceType.TV, "open");
    }
}
