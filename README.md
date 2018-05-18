## 简单使用

```java
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate) context.getBean("jmsQueueTemplate");
        Destination destination = (Destination) context.getBean("defaultQueueDestination");

        JmsUtil.sendMessage(jmsTemplate, destination, "Hello World");
    }
}
```

## 一些细节

- 由于没有使用Spring MVC而是使用了原始的Servlet，Servlet是由Web容器管理的，所以无法完成Spring的自动注入，解决的方式有很多，这里使用了静态代理类的方式处理。  
- 没有使用`org.springframework.jms.support.converter.MessageConverter`，如果有需要，可以实现该接口，完成消息的转换。
