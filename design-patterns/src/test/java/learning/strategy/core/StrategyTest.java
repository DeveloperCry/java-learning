package learning.strategy.core;

import learning.strategy.core.IdeaMan;
import learning.strategy.core.support.LifeStrategy;
import learning.strategy.core.support.MakeMoneyStrategy;
import learning.strategy.core.support.PlayStrategy;
import org.junit.Test;

public class StrategyTest {
    @Test
    public void testStrategy() {
        IdeaMan lifeIdeaMan = new IdeaMan(new LifeStrategy());
        lifeIdeaMan.executeThinkIdea();

        IdeaMan makeMoneyIdeaMan = new IdeaMan(new MakeMoneyStrategy());
        makeMoneyIdeaMan.executeThinkIdea();

        IdeaMan playIdeaMan = new IdeaMan(new PlayStrategy());
        playIdeaMan.executeThinkIdea();
    }
}
