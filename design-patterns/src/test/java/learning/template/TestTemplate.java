package learning.template;

import learning.template.support.ChongQingUser;
import learning.template.support.HuNanUser;
import learning.template.support.SiChuanUser;
import org.junit.Test;

public class TestTemplate {

    @Test
    public void testUser() {
        SiChuanUser siChuanUser = new SiChuanUser();
        siChuanUser.eat();

        ChongQingUser chongQingUser = new ChongQingUser();
        chongQingUser.eat();

        HuNanUser huNanUser = new HuNanUser();
        huNanUser.eat();
    }
}
