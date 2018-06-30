package com.learn.camel.routes.mock;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class SampleMockRouteTest extends CamelTestSupport{

    @Override
    public RoutesBuilder createRouteBuilder(){
        return new SampleMockRoute();
    }

    @Test
    public void SamepleDirectMockTest() throws InterruptedException {

        // Checking against the below string
        String input = "Hello Mumbai";

        MockEndpoint mock = getMockEndpoint("mock:outPut");
        mock.expectedBodiesReceived(input);

        Thread.sleep(2000);
        template.sendBody("direct:sampleInput", "Hello Mumbai");


        assertMockEndpointsSatisfied();
    }
}
