package learning.state;

public class DraftState extends State {
    public DraftState(Context context) {
        super(context);
    }

    @Override
    public void render() {
        System.out.println("提交当前博客");
        super.context.setState(super.context.getModeration());
    }

    @Override
    public boolean review() {
        System.out.println("博客没有提交，不能审核");
        return false;
    }

    @Override
    public void publish() {
        System.out.println("博客没有提交，不能发布");
    }
}
