package ru.gazpromneft_at;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.gazpromneft_at.model.Messaga;


public class MessageReceiver {

//    @JmsListener(destination = "que1")
    public void receiveMessage(Messaga messaga){

    }
}
