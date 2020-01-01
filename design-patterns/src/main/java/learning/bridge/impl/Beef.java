package learning.bridge.impl;

import learning.bridge.Meat;

public class Beef implements Meat {
    @Override
    public float getWeight() {
        return 2.5f;
    }

    @Override
    public float getHardness() {
        return 1.5f;
    }
}
