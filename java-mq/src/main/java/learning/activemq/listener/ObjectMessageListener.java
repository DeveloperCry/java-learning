package learning.activemq.listener;

import learning.activemq.entity.User;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

public class ObjectMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
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
    }
}
