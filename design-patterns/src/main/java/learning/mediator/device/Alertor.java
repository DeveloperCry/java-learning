package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.Mediator;

public class Alertor extends Device {
    public Alertor(Mediator mediator) {
        super(mediator);
    }

    public void open() {
        System.out.println("我是警报器，正在开启中。。。");
    }

    public void alarm() {
        System.out.println("我是警报器，我在发出警报。。。。");
    }

    public void close() {
        System.out.println("我是报警器，关闭警报");
    }
}
