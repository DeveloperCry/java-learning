package learning.state;

import org.junit.Test;

public class StateTest {
    @Test
    public void testState() {
        for (int i = 0; i < 10; i++) {
            System.out.println("\n=====第" + i + "次发表====");
            Context context = new Context();
            context.setState(new DraftState(context));

            context.render();
            context.publish();
        }

    }
}
