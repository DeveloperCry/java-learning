package learning.activemq.consumer;

import learning.activemq.constants.Constants;
import learning.activemq.util.TimeUtil;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerSync {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                Constants.MQ_SEC_USER,
                Constants.MQ_SEC_PASSWORD,
                Constants.MQ_BROKER_URL);
        factory.setDispatchAsync(true);
        Connection connection = factory.createConnection();
        connection.start();
        // 如果这里的事务(transacted)设置true,则需要手动提交消息确认(ACK)，否则不会发送消息确认(ACK)给MQ服务器，消息会被重复消费。
        // 只有transacted设置为false，第二个参数才会生效，否则第二个参数会被Session.SESSION_TRANSACTED覆盖
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Queue destination = session.createQueue("producer_window_size_mq");

        MessageConsumer consumer = session.createConsumer(destination);

        consumer.setMessageListener(message -> {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage);
                    System.out.println(textMessage.getText());
                    textMessage.acknowledge();
                    TimeUtil.timeSleep(3);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("获取消息失败");
            }
        });
    }
}
