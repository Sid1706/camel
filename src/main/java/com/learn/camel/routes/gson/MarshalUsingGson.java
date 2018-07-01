package com.learn.camel.routes.gson;

import com.learn.camel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class MarshalUsingGson extends RouteBuilder{
    public void configure() throws Exception {

        GsonDataFormat gsonDataFormat = new GsonDataFormat(Employee.class);
        from("direct:input")
                .log("Before Marshaing Message is having baody ${body} header ${headers}")
                .marshal(gsonDataFormat)
                .log("Marshared object is ${body}")
                .to("mock:output");




    }
}
