package com.learn.camel.transform;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyTransfromRoute extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:inputString")
                .log("Camel message is having body ${body} with header ${headers}" )
                .transform(body().regexReplaceAll("-",":"))
                .to("mock:output");
    }
}

