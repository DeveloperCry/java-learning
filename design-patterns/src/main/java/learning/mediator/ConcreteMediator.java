package learning.mediator;

import learning.mediator.device.*;

import java.util.HashMap;
import java.util.Map;

public class ConcreteMediator extends Mediator{
    private Map<DeviceType, Device> deviceMap = new HashMap<>();
    @Override
    public void register(Device device) {
        deviceMap.put(DeviceType.valueOf(device.getClass().getSimpleName().toUpperCase()), device);
    }

    @Override
    public void leaveHome() {
        ((Phone)deviceMap.get(DeviceType.PHONE)).leaveHome();
        ((Sensor)deviceMap.get(DeviceType.SENSOR)).open();
        ((Camera)deviceMap.get(DeviceType.CAMERA)).open();
        ((Alertor)deviceMap.get(DeviceType.ALERTOR)).open();
        ((TV)deviceMap.get(DeviceType.TV)).close();
    }

    @Override
    public void breakIn() {
        ((Sensor)deviceMap.get(DeviceType.SENSOR)).breakIn();
        ((Camera)deviceMap.get(DeviceType.CAMERA)).shoot();
        ((Alertor)deviceMap.get(DeviceType.ALERTOR)).alarm();
    }

    @Override
    public void backHome() {
        ((Phone)deviceMap.get(DeviceType.PHONE)).backHome();
        ((Sensor)deviceMap.get(DeviceType.SENSOR)).close();
        ((Camera)deviceMap.get(DeviceType.CAMERA)).close();
        ((Alertor)deviceMap.get(DeviceType.ALERTOR)).close();
        ((TV)deviceMap.get(DeviceType.TV)).open();
    }

    @Override
    public void sendMessage(String message) {
        ((Phone)deviceMap.get(DeviceType.PHONE)).acceptMessage(message);
    }

    @Override
    public void sendVideo(String video) {
        ((Phone)deviceMap.get(DeviceType.PHONE)).acceptVideo(video);
    }
}
