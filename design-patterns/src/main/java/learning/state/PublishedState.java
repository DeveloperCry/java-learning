package learning.state;

public class PublishedState extends State {
    public PublishedState(Context context) {
        super(context);
    }

    @Override
    public void render() {
        System.out.println("博客已经发布，不能重复提交");
    }

    @Override
    public boolean review() {
        System.out.println("博客已经发布，不能重复审核");
        return false;
    }

    @Override
    public void publish() {
        System.out.println("博客已经发布");
    }
}
