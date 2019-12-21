package learning.strategy.extension.support;

import learning.strategy.extension.IdeaStrategy;
import learning.strategy.extension.entity.MakeMoney;

public class MakeMoneyStrategy implements IdeaStrategy<MakeMoney> {
    @Override
    public void thinkIdea(MakeMoney makeMoney) {
        System.out.println("我是一个思考挣钱的谋士 " + makeMoney.getClass().getName()  + "->" + makeMoney.getClass().getDeclaredFields()[0].getName());
    }
}
