package learning.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {

    private static Map<String, Tank> pool = new HashMap<>();

    public Tank getTank(String model) {
        if (!pool.containsKey(model)) {
            pool.put(model, new Tank(model));
        }
        System.out.println("当前拥有的坦克型号有：" + pool.size() + "种");
        return pool.get(model);
    }
}
