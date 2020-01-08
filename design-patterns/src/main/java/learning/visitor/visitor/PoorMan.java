package learning.visitor.visitor;

import learning.visitor.AbstractVisitor;
import learning.visitor.VisitorType;
import learning.visitor.house.BigHouse;
import learning.visitor.house.MiddleHouse;
import learning.visitor.house.SmallHouse;

public class PoorMan extends AbstractVisitor {
    @Override
    public void callOnSmallHose(SmallHouse smallHouse) {
        smallHouse.display(VisitorType.POOR_MAN);
    }

    @Override
    public void callOnMiddleHose(MiddleHouse middleHouse) {
        middleHouse.display(VisitorType.POOR_MAN);
    }

    @Override
    public void callOnBigHose(BigHouse bigHouse) {
        bigHouse.display(VisitorType.POOR_MAN);
    }
}
