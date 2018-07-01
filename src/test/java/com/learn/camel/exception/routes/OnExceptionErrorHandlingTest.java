package com.learn.camel.exception.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class OnExceptionErrorHandlingTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new OnExceptionErrorHandling();
    }

    @Test
    public void TestException()
    {
        String output = template.requestBody("direct:inputString", null, String.class);


    }
}