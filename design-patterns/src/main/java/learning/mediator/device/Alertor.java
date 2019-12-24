package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.DeviceType;
import learning.mediator.Mediator;
import learning.mediator.OptionType;

public class Alertor extends Device {
    public Alertor(Mediator mediator) {
        super(mediator);
        mediator.register(DeviceType.ALERTOR, this);
    }

    public void open() {
        System.out.println("我是警报器，正在开启中。。。");
    }

    public void alarm() {
        System.out.println("我是警报器，我在发出警报。。。。");
        super.option(DeviceType.PHONE, OptionType.ACCEPT_MESSAGE.getOption(), "警报器响了");
    }

    public void close() {
        System.out.println("我是报警器，关闭警报");
    }
}
