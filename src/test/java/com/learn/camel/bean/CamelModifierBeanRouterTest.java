package com.learn.camel.bean;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CamelModifierBeanRouterTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new CamelModifierBeanRouter();
    }


    @Test
    public  void CamelRouteBeanTest() throws InterruptedException {
        String input = "Hello-this-is-India";
        String expectedOutput = "Hello*this*is*India";

        MockEndpoint mockEndpoint = getMockEndpoint("mock:output");
        mockEndpoint.expectedBodiesReceived(expectedOutput);

        template.sendBody("direct:inputString",input );


       assertMockEndpointsSatisfied();



        String actual = (String) template.requestBody("direct:inputString",input);
        assertEquals(expectedOutput, actual);


    }

}