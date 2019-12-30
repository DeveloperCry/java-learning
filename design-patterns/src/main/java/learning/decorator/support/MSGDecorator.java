package learning.decorator.support;

import learning.decorator.Cook;
import learning.decorator.Decorator;

public class MSGDecorator extends Decorator {

    public MSGDecorator(Cook cook) {
        super(cook);
    }

    @Override
    public String flavor() {
        return "味";
    }

    @Override
    public String description() {
        return "炒" + super.cook.description() + "加味精";
    }
}
