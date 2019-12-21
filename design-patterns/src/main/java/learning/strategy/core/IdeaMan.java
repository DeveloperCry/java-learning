package learning.strategy.core;

/***
 * 谋士
 *
 * 策略模式就是通过传入不同的策略并执行(封装策略)，以后新加一个策略就直接继承策略接口就可以了
 *
 * 这里要和工厂模式区别开来，工厂模式返回的是对象；而策略模式主要是根据给出的策略执行
 */
public class IdeaMan {
    private IdeaStrategy ideaStrategy;

    public IdeaMan(IdeaStrategy ideaStrategy) {
        this.ideaStrategy = ideaStrategy;
    }

    public void executeThinkIdea() {
        this.ideaStrategy.thinkIdea();
    }
}
