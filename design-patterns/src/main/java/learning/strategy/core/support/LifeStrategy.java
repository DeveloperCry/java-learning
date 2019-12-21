package learning.strategy.core.support;

import learning.strategy.core.IdeaStrategy;

public class LifeStrategy implements IdeaStrategy {
    @Override
    public void thinkIdea() {
        System.out.println("我是一个思考怎么生活的谋士");
    }
}
