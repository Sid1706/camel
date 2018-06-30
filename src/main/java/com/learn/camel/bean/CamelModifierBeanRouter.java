package com.learn.camel.bean;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifierBeanRouter extends RouteBuilder {

    public void configure() throws Exception {
     from("direct:inputString")
             .log("Message with body ${body} with header ${headers}")
             // define the class name and method name..
             .bean(new SampleBean(),"map")
             .to("mock:output");


    }
}
