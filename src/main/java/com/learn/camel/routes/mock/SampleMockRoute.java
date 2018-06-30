package com.learn.camel.routes.mock;

import org.apache.camel.builder.RouteBuilder;

public class SampleMockRoute extends RouteBuilder{

    // Upstream & DownStream both systems are not ready.
    public void configure() throws Exception {

        from("direct:sampleInput")
                .log("Sample input with the body ${body} and headers ${headers}")
                .to("mock:outPut");
    }
}
