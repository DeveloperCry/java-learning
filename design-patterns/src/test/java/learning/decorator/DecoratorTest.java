package learning.decorator;

import learning.decorator.support.MSGDecorator;
import learning.decorator.support.SaltDecorator;
import org.junit.Test;

public class DecoratorTest {
    @Test
    public void testDecorator() {
        Cook chili = new Chili();
        chili = new MSGDecorator(chili);
        System.out.println(chili.flavor());
        System.out.println(chili.description());

        chili = new SaltDecorator(chili);
        System.out.println(chili.flavor());
        System.out.println(chili.description());
    }
}
