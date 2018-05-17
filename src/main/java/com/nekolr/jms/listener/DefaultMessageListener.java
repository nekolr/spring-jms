package com.nekolr.jms.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class DefaultMessageListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(DefaultMessageListener.class);

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String text = textMessage.getText();
            logger.info(text);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
