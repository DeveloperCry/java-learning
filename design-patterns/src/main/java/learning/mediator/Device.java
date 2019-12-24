package learning.mediator;

public abstract class Device {
    private Mediator mediator;
    public Device(Mediator mediator) {
        this.mediator = mediator;
    }

    public void option(DeviceType deviceType, String option, Object... objects){//发送执行命令
        this.mediator.doOption(deviceType, option, objects);
    }

    public void option(DeviceType deviceType, String option){//发送执行命令
        this.option(deviceType, option, null);
    }
}
