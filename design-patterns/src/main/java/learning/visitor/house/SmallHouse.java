package learning.visitor.house;

import learning.visitor.AbstractHouse;
import learning.visitor.AbstractVisitor;
import learning.visitor.VisitorType;

public class SmallHouse extends AbstractHouse {
    @Override
    public void display(VisitorType type) {
        if (VisitorType.RICH_MAN.equals(type)) {
            System.out.println("对不起，你是" + type.getLabel() + "，不允许来观看这个房子");
        } else {
            System.out.println(type.getLabel() + " 来看这个小房子");
        }
    }

    @Override
    public void accept(AbstractVisitor visitor) {
        visitor.callOnSmallHose(this);
    }
}
