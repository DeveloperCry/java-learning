package learning.decorator.support;

import learning.decorator.Cook;
import learning.decorator.Decorator;

public class SaltDecorator extends Decorator {

    public SaltDecorator(Cook cook) {
        super(cook);
    }

    @Override
    public String flavor() {
        return "咸味";
    }

    @Override
    public String description() {
        return "炒" + super.cook.description() + "加盐";
    }
}
