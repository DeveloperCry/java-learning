package learning.visitor;

import learning.visitor.house.BigHouse;
import learning.visitor.house.MiddleHouse;
import learning.visitor.house.SmallHouse;
import learning.visitor.visitor.MiddleClass;
import learning.visitor.visitor.PoorMan;
import learning.visitor.visitor.RichMan;
import org.junit.Test;

public class VisitorTest {
    @Test
    public void testVisitor() {
        SmallHouse smallHouse = new SmallHouse();
        MiddleHouse middleHouse = new MiddleHouse();
        BigHouse bigHouse = new BigHouse();

        smallHouse.accept(new PoorMan());
        middleHouse.accept(new MiddleClass());
        bigHouse.accept(new RichMan());
    }


    @Test
    public void testVisitorStructure() {
        ObjectStructure structure = new ObjectStructure();
        structure.attach(new SmallHouse());
        structure.attach(new MiddleHouse());
        structure.attach(new BigHouse());

        System.out.println("===================");
        structure.display(new PoorMan());
    }
}
