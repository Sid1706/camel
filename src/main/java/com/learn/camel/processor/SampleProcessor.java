package com.learn.camel.processor;

import org.apache.camel.Exchange;

public class SampleProcessor implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {

        String input = exchange.getIn().getBody().toString();

        input = input.replace("-" ,":");
        System.out.println(input);

        System.out.println(exchange.getOut().toString());
        exchange.getIn().setBody(input);
    }
}
