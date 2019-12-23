package learning.mediator;

import java.util.Map;

/**
 * 我们以米家为例，所有的设备都连接到米家多功能网关中
 * 角色：
 *     网关(中介者)：核心类，执行相应的方法
 *     米家设备(同事类)：只知道自己的的行为，而不了解其他设备的行为，他们是相互独立的（核心思想）；但是他们都依赖中介者。
 */
public abstract class Mediator {
    public abstract void register(DeviceType deviceType, Device device);
    public abstract void doOption();
}
