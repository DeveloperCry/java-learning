package learning.bridge;

import learning.bridge.impl.Pork;
import learning.bridge.support.Saute;
import learning.bridge.support.Stew;
import org.junit.Test;

public class BridgeTest {
    @Test
    public void testBridge() {
        Cook cook = new Stew(new Pork());
        cook.cut();
        cook.cookingTime();

        cook = new Saute(new Pork());
        cook.cut();
        cook.cookingTime();
    }
}
