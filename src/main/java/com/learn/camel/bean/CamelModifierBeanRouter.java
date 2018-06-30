package com.learn.camel.bean;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifierBeanRouter extends RouteBuilder {

    public void configure() throws Exception {
     from("direct:inputString")
             .log("Message with body ${body} with header ${headers}")
             .bean(new SampleBean())
             .to("mock:output");


    }
}
