package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.DeviceType;
import learning.mediator.Mediator;

public class Camera extends Device {
    public Camera(Mediator mediator) {
        super(mediator);
        mediator.register(DeviceType.CAMERA, this);
    }

    public void open() {
        System.out.println("打开摄像头。。。");
    }

    public void close() {
        System.out.println("关闭摄像头。。。");
    }

    public void shoot() {
        System.out.println("我是摄像机，我拍摄到有画面。。。");
    }
}
