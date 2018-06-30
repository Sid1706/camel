package com.learn.camel.routes.direct;

import org.apache.camel.CamelContext;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;

public class SampleDirectRoute extends RouteBuilder {

    public void configure() throws Exception {
     from("direct:sampleInput").log("received input is ${body} and header are ${headers}")
             .to("file:sampleOutput?fileName=output.txt");
    }
}
