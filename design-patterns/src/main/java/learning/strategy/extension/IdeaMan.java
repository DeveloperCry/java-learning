package learning.strategy.extension;

/***
 * 谋士
 *
 * 这个是一个策略模式的扩展，这里传入了对象，这样的就可以操作对象了
 */
public class IdeaMan<T> {
    private IdeaStrategy<T> ideaStrategy;

    public IdeaMan(IdeaStrategy<T> ideaStrategy) {
        this.ideaStrategy = ideaStrategy;
    }

    public void executeThinkIdea(T t) {
        this.ideaStrategy.thinkIdea(t);
    }
}
