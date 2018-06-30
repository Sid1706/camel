package com.learn.camel.routes.xmlstream;

import com.learn.camel.processor.CustomProcessorXstream;
import org.apache.camel.builder.RouteBuilder;

public class MarshalUsingXtream extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:inputString")
                .log("Input message recevived with body ${body} & header ${headers} ")
                .process(new CustomProcessorXstream())
                .to("mock:output");

    }
}
