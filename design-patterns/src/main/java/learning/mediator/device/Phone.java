package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.Mediator;

public class Phone extends Device {
    public Phone(Mediator mediator) {
        super(mediator);
    }

    public void acceptVideo(String video) {
        System.out.println("我接收到的视频是 " + video);
    }

    public void acceptMessage(String message) {
        System.out.println("我接收到的信息是 " + message);
    }

    public void leaveHome() {
        System.out.println("我离开家了");
    }

    public void backHome() {
        System.out.println("我回家了");
    }
}
