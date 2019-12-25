package learning.mediator;

public abstract class Device {
    protected Mediator mediator;
    public Device(Mediator mediator) {
        this.mediator = mediator;
    }
}
