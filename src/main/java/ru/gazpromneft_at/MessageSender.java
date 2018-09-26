package ru.gazpromneft_at;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import ru.gazpromneft_at.model.Messaga;


public class MessageSender {


    private final JmsTemplate jmsTemplate;


    public MessageSender(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }


    /**
     * Поставить сообщение в очередь.
     */
    public void sendMessage(){
        jmsTemplate.sendAndReceive("que1", (MessageCreator) new Messaga(1L, "Helloworld!"));
    }
}
