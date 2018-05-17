package com.nekolr.jms.util;

import org.apache.activemq.ScheduledMessage;
import org.springframework.jms.core.JmsTemplate;
import javax.jms.Destination;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;
import java.io.Serializable;

public class JmsUtil {

    private JmsUtil() {
    }

    /**
     * 发送文本消息
     *
     * @param jmsTemplate
     * @param destination
     * @param message
     */
    public static void sendMessage(JmsTemplate jmsTemplate, Destination destination, final String message) {
        jmsTemplate.send(destination, (session) -> session.createTextMessage(message));
    }

    /**
     * 发送对象消息
     *
     * @param jmsTemplate
     * @param destination
     * @param message
     */
    public static void sendMessage(JmsTemplate jmsTemplate, Destination destination, final Serializable message) {
        jmsTemplate.send(destination, (session) -> session.createObjectMessage(message));
    }

    /**
     * 延迟发送文本消息
     *
     * @param jmsTemplate
     * @param destination
     * @param message
     * @param delay
     */
    public static void sendMessageDelay(JmsTemplate jmsTemplate, Destination destination, final String message, final long delay) {
        jmsTemplate.send(destination, (session) -> {
            TextMessage textMessage = session.createTextMessage(message);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, 1 * 1000);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, 1);
            return textMessage;
        });
    }

    /**
     * 延迟发送对象消息
     *
     * @param jmsTemplate
     * @param destination
     * @param message
     * @param delay
     */
    public static void sendMessageDelay(JmsTemplate jmsTemplate, Destination destination, final Serializable message, final long delay) {
        jmsTemplate.send(destination, (session) -> {
            ObjectMessage objectMessage = session.createObjectMessage(message);
            objectMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
            objectMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, 1 * 1000);
            objectMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, 1);
            return objectMessage;
        });
    }
}
