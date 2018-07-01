package com.learn.camel.xml2json;

import org.apache.camel.builder.RouteBuilder;

public class XML2Json extends RouteBuilder {
    public void configure() throws Exception {
        from("direct:inputXML")
                .log("message body - ${body} and header - ${headers}")
                .marshal()
                .xmljson()
                .log(" after marshaling message body - ${body} and header - ${headers}")
                .to("mock:output");
    }
}
