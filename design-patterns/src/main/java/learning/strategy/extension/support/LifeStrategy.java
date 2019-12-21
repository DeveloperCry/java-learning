package learning.strategy.extension.support;

import learning.strategy.extension.IdeaStrategy;
import learning.strategy.extension.entity.Life;

public class LifeStrategy implements IdeaStrategy<Life> {
    @Override
    public void thinkIdea(Life life) {

        System.out.println("我是一个思考怎么生活的谋士 " + life.getClass().getName()  + "->" + life.getClass().getDeclaredFields()[0].getName());
    }
}
