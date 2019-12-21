package learning.strategy.extension;

import learning.strategy.extension.entity.Life;
import learning.strategy.extension.entity.MakeMoney;
import learning.strategy.extension.entity.Play;
import learning.strategy.extension.support.LifeStrategy;
import learning.strategy.extension.support.MakeMoneyStrategy;
import learning.strategy.extension.support.PlayStrategy;
import org.junit.Test;

public class StrategyTest {
    @Test
    public void testStrategy() {
        IdeaMan<Life> lifeIdeaMan = new IdeaMan<>(new LifeStrategy());
        lifeIdeaMan.executeThinkIdea(new Life());

        IdeaMan<MakeMoney> makeMoneyIdeaMan = new IdeaMan<>(new MakeMoneyStrategy());
        makeMoneyIdeaMan.executeThinkIdea(new MakeMoney());

        IdeaMan<Play> playIdeaMan = new IdeaMan<>(new PlayStrategy());
        playIdeaMan.executeThinkIdea(new Play());
    }
}
