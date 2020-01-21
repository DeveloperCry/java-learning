package learning.activemq.consumer;

import learning.activemq.constants.Constants;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Map;

public class ConsumerSelector {
    public static void main(String[] args) throws JMSException {
//        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
//                Constants.MQ_USER_NAME,
//                Constants.MQ_PASSWORD,
//                Constants.MQ_BROKER_URL);//一定要注意这里的端口号，还有使用的协议，一定要和启动服务器时那些端口一致
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                Constants.MQ_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        // 如果这里的事务(transacted)设置true,则需要手动提交消息确认(ACK)，否则不会发送消息确认(ACK)给MQ服务器，消息会被重复消费。
        // 只有transacted设置为false，第二个参数才会生效，否则第二个参数会被Session.SESSION_TRANSACTED覆盖
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue destination = session.createQueue("selector_mq");

        String filter = "group < 8";
        MessageConsumer consumer = session.createConsumer(destination, filter);

        consumer.setMessageListener(message -> {
            if (message instanceof MapMessage) {
                MapMessage mapMessage = (MapMessage) message;
                try {
                    System.out.println(mapMessage.getString("name"));
                    System.out.println(mapMessage.getStringProperty("group"));
                    System.out.println(mapMessage.getStringProperty("p"));
                    System.out.println("=============");
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            } else if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage.getText());
                    System.out.println("=============");
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("获取对象失败");
            }
        });
    }
}
