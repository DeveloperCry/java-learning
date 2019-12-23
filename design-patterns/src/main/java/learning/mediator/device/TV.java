package learning.mediator.device;

import learning.mediator.Device;
import learning.mediator.DeviceType;
import learning.mediator.Mediator;

public class TV extends Device {
    public TV(Mediator mediator) {
        super(mediator);
        mediator.register(DeviceType.TV, this);
    }

    @Override
    public void option(DeviceType deviceType) {

    }
}
