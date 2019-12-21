package learning.strategy.core.support;

import learning.strategy.core.IdeaStrategy;

public class MakeMoneyStrategy implements IdeaStrategy {
    @Override
    public void thinkIdea() {
        System.out.println("我是一个思考挣钱的谋士");
    }
}
