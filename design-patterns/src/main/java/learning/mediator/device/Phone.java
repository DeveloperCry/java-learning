package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.DeviceType;
import learning.mediator.Mediator;
import learning.mediator.OptionType;

public class Phone extends Device {
    public Phone(Mediator mediator) {
        super(mediator);
        mediator.register(DeviceType.PHONE, this);
    }

    public void acceptVideo(String video) {
        System.out.println("我接收到的视频是 " + video);
    }

    public void acceptMessage(String message) {
        System.out.println("我接收到的信息是 " + message);
    }

    public void leaveHome() {
        System.out.println("我离开家了");
        super.option(DeviceType.CAMERA, OptionType.OPEN.getOption());
        super.option(DeviceType.ALERTOR, OptionType.OPEN.getOption());
        super.option(DeviceType.SENSOR, OptionType.OPEN.getOption());
        super.option(DeviceType.TV, OptionType.CLOSE.getOption());
    }

    public void backHome() {
        System.out.println("我回家了");
        super.option(DeviceType.CAMERA, OptionType.CLOSE.getOption());
        super.option(DeviceType.ALERTOR, OptionType.CLOSE.getOption());
        super.option(DeviceType.SENSOR, OptionType.CLOSE.getOption());
        super.option(DeviceType.TV, OptionType.OPEN.getOption());
    }
}
