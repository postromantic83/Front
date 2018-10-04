package ru.gazpromneft_at.components;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import ru.gazpromneft_at.model.Messaga;

public class kspdProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        String correlation = (String) exchange.getMessage().getHeader("JMSCorrelationID");
        exchange.getOut().setBody(new Messaga(345L, "Proceseed with KSPD!"));
        exchange.getOut().setHeader("JMSCorrelationID", correlation);
        exchange.getOut().setHeader("Accept", "Application/json");
        exchange.getOut().setHeader("Content-Type", "application/json; charset=UTF-8");
    }
}
