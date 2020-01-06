package learning.state;

import org.apache.commons.lang3.RandomUtils;

public class ModerationState extends State {
    public ModerationState(Context context) {
        super(context);
    }

    @Override
    public void render() {
        System.out.println("博客已经提交，不能重复提交");
    }

    @Override
    public boolean review() {
        System.out.println("正在审核博客");
        boolean isPassed = RandomUtils.nextBoolean();
        if (isPassed) {
            System.out.println("博客审核通过");
            super.context.setState(super.context.getPublished());
        } else {
            System.out.println("博客没有审核通过，需要重新提交");
            super.context.setState(super.context.getDraft());
        }
        return isPassed;
    }

    @Override
    public void publish() {
        System.out.println("博客正在审核不能发布");
    }
}
