package ru.gazpromneft_at.components;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.qpid.jms.JmsDestination;
import org.apache.qpid.jms.JmsQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;

@Component
public class MessageProcessor implements Processor {
    private Logger logger = LogManager.getLogger(MessageProcessor.class);

    @Autowired
    private org.apache.qpid.jms.JmsConnectionFactory amqpDmzConnectionFactory;

    public void process(Exchange exchange) throws Exception {
//        Message message = exchange.getMessage();
        logger.info("START PROCESSOR!");

            Connection connection = amqpDmzConnectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination queue = new JmsQueue("que_out");
            MessageConsumer consumer = session.createConsumer(queue);
            connection.start();
            try {
                TextMessage messageReceived = (TextMessage) consumer.receive();
                exchange.getIn().setBody(messageReceived.getText());
            } catch (Exception e){
                logger.error("Ошибка получения сообщения!" + e.getMessage());
                exchange.getIn().setBody("Ошибка получения сообщения!");
        }

            connection.stop();
            connection.close();


    }
}
