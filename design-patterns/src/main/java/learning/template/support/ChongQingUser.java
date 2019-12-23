package learning.template.support;

import learning.template.AbstractUser;

public class ChongQingUser extends AbstractUser {
    @Override
    protected String province() {
        return "重庆人";
    }

    @Override
    protected String food() {
        return "火锅";
    }
}
