package learning.mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteMediator extends Mediator{
    private Map<DeviceType, Device> deviceMap = new HashMap<>();
    @Override
    public void register(DeviceType deviceType, Device device) {
        deviceMap.put(deviceType, device);
    }

    @Override
    public void doOption() {

    }
}
