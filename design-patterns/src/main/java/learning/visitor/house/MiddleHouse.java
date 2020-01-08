package learning.visitor.house;

import learning.visitor.AbstractHouse;
import learning.visitor.AbstractVisitor;
import learning.visitor.VisitorType;

public class MiddleHouse extends AbstractHouse {
    @Override
    public void display(VisitorType type) {
        System.out.println(type.getLabel() + " 来看这个中等房子");
    }

    @Override
    public void accept(AbstractVisitor visitor) {
        visitor.callOnMiddleHose(this);
    }
}
