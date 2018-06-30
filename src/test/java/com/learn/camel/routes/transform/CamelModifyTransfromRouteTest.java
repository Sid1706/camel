package com.learn.camel.routes.transform;

import com.learn.camel.transform.CamelModifyTransfromRoute;
import com.learn.camel.transform.FileProcessingRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class CamelModifyTransfromRouteTest extends CamelTestSupport {
    @Override
    public RoutesBuilder createRouteBuilder(){
        return new CamelModifyTransfromRoute();
    }

    @Test
    public void SamepleDirectMockTest() throws InterruptedException {

        String input = "Hello-Bangalore-We love you";
        String output = "Hello:Bangalore:We love you";

        MockEndpoint mock = getMockEndpoint("mock:output");
        mock.expectedBodiesReceived(output);
        Thread.sleep(2000);
        template.sendBody("direct:inputString", input);
        assertMockEndpointsSatisfied();


    // Secondway of doing same test case
        String actual = (String)template.requestBody("direct:inputString", input);
        assertEquals(output,actual);

    }

}