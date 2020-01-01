package learning.bridge.impl;

import learning.bridge.Meat;

public class Pork implements Meat {
    @Override
    public float getWeight() {
        return 3.5f;
    }

    @Override
    public float getHardness() {
        return 1.0f;
    }
}
