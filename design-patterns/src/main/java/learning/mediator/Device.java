package learning.mediator;

public abstract class Device {
    private Mediator mediator;
    public Device(Mediator mediator) {
        this.mediator = mediator;
    }
    public abstract void option(DeviceType deviceType);
}
