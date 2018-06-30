package com.learn.camel.routes.file;

import org.apache.camel.builder.RouteBuilder;

public class FileCopyRouter extends RouteBuilder {

    public void configure() throws Exception {

        from("file:data/input?noop=true")
                .to("file:data/output");
    }
}
