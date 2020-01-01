package learning.adapter;

/**
 * 这里是通过一个例子将本地系统的用户信息经过适配器的转换成第三方接口需要的参数形式然后传递
 *
 * 将一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。
 * 换句话说，适配器模式就是把一个接口或类转换成其他的接口或类
 *
 * 这个模式将没有关系的两个类关联在了一起
 *
 * 这个模式适合于接口之间的转换
 */
public class TransferUserInfoAdapter implements TransferUserInfo{
    private UserInfo userInfo;

    public TransferUserInfoAdapter(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String getTransferUsername() {
        return this.userInfo.getUsername();
    }

    @Override
    public String getTransferPhone() {
        return this.userInfo.getPhone();
    }

    @Override
    public String getTransferEmail() {
        return this.userInfo.getEmail();
    }
}
