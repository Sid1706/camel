package com.learn.camel.routes.gson;

import com.learn.camel.domain.Employee;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.gson.GsonDataFormat;

public class UnMarshalUsingGson extends RouteBuilder{
    public void configure() throws Exception {

        GsonDataFormat format = new GsonDataFormat(Employee.class);
      from("direct:input")
              .log(" Here is input - body ${body} & header ${headers}")
              .unmarshal(format)
              .log("Output - body ${body} & header ${headers}")
              .to("mock:output");
    }
}
