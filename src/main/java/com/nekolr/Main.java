package com.nekolr;

import com.nekolr.jms.util.JmsUtil;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Destination;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsQueueTemplate");
        Destination destination = (Destination) context.getBean("defaultQueueDestination");

        JmsUtil.sendMessage(jmsTemplate, destination, "Hello World");
    }
}
