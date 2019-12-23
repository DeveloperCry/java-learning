package learning.template.support;

import learning.template.AbstractUser;

public class SiChuanUser extends AbstractUser {
    @Override
    protected String province() {
        return "四川人";
    }

    @Override
    protected String food() {
        return "川菜";
    }
}
