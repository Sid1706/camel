package com.learn.camel.exception.routes;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DefaultErrorHandlerTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new DefaultErrorHandler();
    }

    @Test
    public void errorDefaultHandlerTest()
    {
        String input = "we-live-in-Bangalore.";

        String output = template.requestBody("direct:inputString",input,String.class);

        assertEquals("we*live*in*Bangalore.",output);
    }

    @Test
    public void testAnotherWay() throws InterruptedException {
        String input = "we-live-in-Bangalore.";
        String expected = "we*live*in*Bangalore.";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:outputString");
        mockEndpoint.expectedBodiesReceived(expected);

        template.sendBody("direct:inputString",input);

        assertMockEndpointsSatisfied();

    }

    @Test(expected = java.lang.RuntimeException.class)
    public void errorDefaultHandlerExceptionTest()
    {
        String input = "we-live-in-Bangalore.";
        String output = template.requestBody("direct:inputString",null,String.class);
      //  assertEquals("we*live*in*Bangalore.",output);
    }

}