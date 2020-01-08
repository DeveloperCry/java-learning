package learning.visitor.visitor;

import learning.visitor.AbstractVisitor;
import learning.visitor.VisitorType;
import learning.visitor.house.BigHouse;
import learning.visitor.house.MiddleHouse;
import learning.visitor.house.SmallHouse;

public class MiddleClass extends AbstractVisitor {
    @Override
    public void callOnSmallHose(SmallHouse smallHouse) {
        smallHouse.display(VisitorType.MIDDLE_CLASS);
    }

    @Override
    public void callOnMiddleHose(MiddleHouse middleHouse) {
        middleHouse.display(VisitorType.MIDDLE_CLASS);
    }

    @Override
    public void callOnBigHose(BigHouse bigHouse) {
        bigHouse.display(VisitorType.MIDDLE_CLASS);
    }
}
