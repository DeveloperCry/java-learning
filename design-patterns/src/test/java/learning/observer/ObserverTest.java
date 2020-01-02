package learning.observer;

import org.junit.Test;

public class ObserverTest {
    @Test
    public void testObserver() {
        TaoBao publisher = new TaoBao();
        publisher.add(new Buyer());
        publisher.add(new Competitor());

        publisher.publish();
    }
}
