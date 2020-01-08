package learning.visitor;

/**
 * 被访问者
 */
public abstract class AbstractHouse {
    public abstract void display(VisitorType type);
    public abstract void accept(AbstractVisitor visitor);
}
