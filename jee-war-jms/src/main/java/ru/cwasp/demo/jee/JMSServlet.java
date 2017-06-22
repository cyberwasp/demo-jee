package ru.cwasp.demo.jee;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.JMSProducer;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("jms")
public class JMSServlet extends HttpServlet {

    @Resource(mappedName = "java:/jms/queue/testQueue")
    private Queue queue;

    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    private JMSContext context;

    private JMSConsumer consumer;

    @PostConstruct
    public void init() {
        consumer = context.createConsumer(queue);
        consumer.setMessageListener(message -> {
            try {
                System.out.println("Получено сообщение: " + message.getBody(String.class));
                message.acknowledge();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
    }

    @PreDestroy
    public void done() {
        consumer.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JMSProducer producer = context.createProducer();
        producer.send(queue, req.getParameter("message"));
    }
}
