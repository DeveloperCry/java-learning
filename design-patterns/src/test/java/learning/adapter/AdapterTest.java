package learning.adapter;

import org.junit.Test;

public class AdapterTest {
    @Test
    public void testAdapter() {
        UserInfo userInfo = new UserInfo("zhangsan", "12345678925", "test@test.com");
        TransferUserInfoAdapter transferUserInfo = new TransferUserInfoAdapter(userInfo);

        System.out.println(transferUserInfo.getTransferUsername());
        System.out.println(transferUserInfo.getTransferPhone());
        System.out.println(transferUserInfo.getTransferEmail());

    }
}
