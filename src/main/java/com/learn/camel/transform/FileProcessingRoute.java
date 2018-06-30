package com.learn.camel.transform;

import com.learn.camel.processor.SampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class FileProcessingRoute extends RouteBuilder{

    SampleProcessor processor = new SampleProcessor();
    public void configure() throws Exception {
        from("direct:SampleInput")
                .log("Inside the route with the body ${body} and header ${headers}")
                .process(processor)
                .log("Inside the route after transformation with the body ${body} and header ${headers}")
                .to("mock:outPut");
    }
}
