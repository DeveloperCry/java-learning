package learning.activemq.consumer;

import learning.activemq.constants.Constants;
import learning.activemq.entity.User;
import learning.activemq.listener.ObjectMessageListener;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.*;

public class ConsumerListener {
    public static void main(String[] args) throws JMSException {
//        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
//                Constants.MQ_USER_NAME,
//                Constants.MQ_PASSWORD,
//                Constants.MQ_BROKER_URL);//一定要注意这里的端口号，还有使用的协议，一定要和启动服务器时那些端口一致
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                Constants.MQ_BROKER_URL);
        factory.setTrustAllPackages(true);//添加对所有类的信任，否则在接收ObjectMessage的时候会异常
        Connection connection = factory.createConnection();
        connection.start();
        // 如果这里的事务(transacted)设置true,则需要手动提交消息确认(ACK)，否则不会发送消息确认(ACK)给MQ服务器，消息会被重复消费。
        // 只有transacted设置为false，第二个参数才会生效，否则第二个参数会被Session.SESSION_TRANSACTED覆盖
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue destination = session.createQueue("mq");

        MessageConsumer consumer = session.createConsumer(destination);

//        consumer.setMessageListener(new ObjectMessageListener());
        consumer.setMessageListener((message) -> {
            if (message instanceof ActiveMQObjectMessage) {
                ObjectMessage objectMessage = (ObjectMessage) message;
                User user = null;
                try {
                    user = (User) objectMessage.getObject();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
                if (user != null) {
                    System.out.println(user.toString());
                } else {
                    System.out.println("接收消息失败");
                }
            }
        System.out.println("消息接收完成");
        });
    }
}
