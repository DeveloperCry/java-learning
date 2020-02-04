package learning.activemq.sender;

import learning.activemq.constants.Constants;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class SenderSync {
    public static void main(String[] args) throws JMSException {
        // 1. 建立工厂对象
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(
                Constants.MQ_SEC_USER,
                Constants.MQ_SEC_PASSWORD,
                Constants.MQ_BROKER_URL);
        // 2. 从工厂里拿一个连接
        ActiveMQConnection connection = (ActiveMQConnection) factory.createConnection();
        connection.setProducerWindowSize(3);
        connection.setAlwaysSyncSend(true);
        connection.setUseAsyncSend(false);
        connection.start();//这里一定不要忘记start，否则无法启动
        // 3. 从连接中获取Session(会话)
        // 如果这里的事务(transacted)设置true,则需要手动提交事务，否则消息不会被提交到MQ服务器。
        // 并且只要消息没有被提交，则可以rollback；如果被提交了，则不能rollback
        // 只有transacted设置为false，第二个参数才会生效，否则第二个参数会被Session.SESSION_TRANSACTED覆盖
        Session session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        // 4. 从会话中获取目的地(Destination)消费者会从这个目的地取消息
        Queue destination = session.createQueue("producer_window_size_mq");

        // 5. 从会话中创建消息提供者
        MessageProducer producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for (int i = 0; i < 10000; i++) {
            // 6. 从会话中创建文本消息(也可以创建其它类型的消息体)
            TextMessage textMessage = session.createTextMessage("这是第" + i + "条activeMQ消息");
            // 7. 通过消息提供者发送消息到ActiveMQ
            producer.send(textMessage);
            System.out.println("这是第" + i + "条信息");
        }
        System.out.println("消息发送成功");

        // 8. 关闭连接，这个一定不要忘记了
        connection.close();
    }
}
