package com.learn.camel.exception.routes;

import com.learn.camel.bean.ErrorHandlingBean;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class DefaultErrorHandler extends RouteBuilder {
    public void configure() throws Exception {

        //errorHandler(defaultErrorHandler());

        errorHandler(defaultErrorHandler().maximumRedeliveries(3).redeliveryDelay(3000)
                .retriesExhaustedLogLevel(LoggingLevel.WARN));

        from("direct:inputString")
                .log("Here is meeage with body ${body} header ${headers}")
                .bean(new ErrorHandlingBean(),"getTransformedString")
                .log("Here is meeage with body ${body} header ${headers} after transformation")
                .to("mock:outputString");
    }
}
