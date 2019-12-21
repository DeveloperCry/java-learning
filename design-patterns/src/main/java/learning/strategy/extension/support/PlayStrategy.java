package learning.strategy.extension.support;

import learning.strategy.extension.IdeaStrategy;
import learning.strategy.extension.entity.Play;

public class PlayStrategy implements IdeaStrategy<Play> {
    @Override
    public void thinkIdea(Play play) {
        System.out.println("我是一个思考怎么玩的谋士 "  + play.getClass().getName()  + "->" + play.getClass().getDeclaredFields()[0].getName());
    }
}
