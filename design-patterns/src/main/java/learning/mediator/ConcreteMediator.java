package learning.mediator;

import learning.mediator.device.TV;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ConcreteMediator extends Mediator{
    private Map<DeviceType, Device> deviceMap = new HashMap<>();
    @Override
    public void register(DeviceType deviceType, Device device) {
        deviceMap.put(deviceType, device);
    }

    @Override
    public void doOption(DeviceType deviceType, String option) {
//        Object object = deviceMap.get(deviceType);
        try {
//            if (object instanceof TV) {
//                TV tv = (TV) object;
//                tv.getClass().getDeclaredMethod(option);
//            } es
            deviceMap.get(deviceType).getClass().getDeclaredMethod(option, new Class[]{}).invoke(deviceMap.get(deviceType));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


}
