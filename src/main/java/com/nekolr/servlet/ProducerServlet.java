package com.nekolr.servlet;

import com.nekolr.jms.util.JmsUtil;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component(value = "producer")
public class ProducerServlet extends HttpServlet {

    @Resource(name = "jmsQueueTemplate")
    private JmsTemplate jmsTemplate;
    @Resource(name = "defaultQueueDestination")
    private Destination destination;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String uri = req.getRequestURI();
        if ("/producer/sendMessage".equals(uri)) {
            String message = req.getParameter("message");
            this.sendMessage(message);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        this.doGet(req, resp);
    }

    private void sendMessage(String message) {
        JmsUtil.sendMessage(jmsTemplate, destination, message);
    }
}
