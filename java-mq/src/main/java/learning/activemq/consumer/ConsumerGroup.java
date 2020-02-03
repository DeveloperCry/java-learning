package learning.activemq.consumer;

import learning.activemq.constants.Constants;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消费端会自动根据分组(groupId)来分配，分组相同的信息(groupID)会由同一个消费端消费，同时这个也有负载均衡的概念
 * 这个与消息独占和消息selector有区别，这个消费端不用进行任何的设置
 */
public class ConsumerGroup {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                Constants.MQ_BROKER_URL);
        Connection connection = factory.createConnection();
        connection.start();
        // 如果这里的事务(transacted)设置true,则需要手动提交消息确认(ACK)，否则不会发送消息确认(ACK)给MQ服务器，消息会被重复消费。
        // 只有transacted设置为false，第二个参数才会生效，否则第二个参数会被Session.SESSION_TRANSACTED覆盖
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue destination = session.createQueue("group_mq");

        MessageConsumer consumer = session.createConsumer(destination);

        consumer.setMessageListener(message -> {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println(message);
                try {
                    System.out.println(textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("获取信息失败");
            }
        });
    }
}
