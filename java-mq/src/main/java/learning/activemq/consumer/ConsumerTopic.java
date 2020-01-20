package learning.activemq.consumer;

import learning.activemq.constants.Constants;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerTopic {
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
//        connection.setClientID("topic2");
        connection.start();
        // 如果这里的事务(transacted)设置true,则需要手动提交消息确认(ACK)，否则不会发送消息确认(ACK)给MQ服务器，消息会被重复消费。
        // 只有transacted设置为false，第二个参数才会生效，否则第二个参数会被Session.SESSION_TRANSACTED覆盖
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic destination = session.createTopic("topic_mq");

        //用这种方式就可以实现topic的持久化，但是意义不大，因为topic只能让正在监听的消费者消费，没有监听的消费者不能消费
//        TopicSubscriber subscriber = session.createDurableSubscriber(destination, "topic2");
        MessageConsumer consumer = session.createConsumer(destination);

        System.out.println("开始接收消息：");
        while (true) {
//            TextMessage message = (TextMessage) subscriber.receive();
            TextMessage message = (TextMessage) consumer.receive();
            System.out.println(message.getText());
        }
    }
}
