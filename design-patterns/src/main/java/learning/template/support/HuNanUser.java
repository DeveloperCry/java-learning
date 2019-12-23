package learning.template.support;

import learning.template.AbstractUser;

public class HuNanUser extends AbstractUser {
    @Override
    protected String province() {
        return "湖南人";
    }

    @Override
    protected String food() {
        return "湘菜";
    }
}
