package com.learn.camel.exception.routes;

import com.learn.camel.bean.ErrorHandlingBean;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.omg.CORBA.portable.ApplicationException;

public class OnExceptionErrorHandling extends RouteBuilder{
    public void configure() throws Exception {

        onException(RuntimeException.class,ApplicationException.class).continued(true)
                .log(LoggingLevel.WARN, "Exception in Processor caught here");

        onException(NullPointerException.class).continued(true)
                .log(LoggingLevel.ERROR, "Exception in Processor caught here Null Pointer exception");


        from("direct:inputString")
                .log("Here is meeage with body ${body} header ${headers}")
                .bean(new ErrorHandlingBean(),"getTransformedString")
                .log("Here is meeage with body ${body} header ${headers} after transformation")
                .to("mock:outputString");
    }
}
