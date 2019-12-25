package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.Mediator;

public class TV extends Device {
    public TV(Mediator mediator) {
        super(mediator);
    }

    public void open() {
        System.out.println("我正在打开电视。。。。");
    }

    public void close() {
        System.out.println("我正在关闭电视。。。。");
    }
}
