package com.learn.camel.routes.transform;

import com.learn.camel.routes.mock.SampleMockRoute;
import com.learn.camel.transform.FileProcessingRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class FileProcessingRouteTest extends CamelTestSupport {
    @Override
    public RoutesBuilder createRouteBuilder(){
        return new FileProcessingRoute();
    }

    @Test
    public void SamepleDirectMockTest() throws InterruptedException {

        String input = "Hello-Bangalore-We love you";

        String expected = "Hello:Bangalore:We love you";

        MockEndpoint mock = getMockEndpoint("mock:outPut");
        mock.expectedBodiesReceived(expected);

        Thread.sleep(2000);
        template.sendBody("direct:SampleInput", input);


        assertMockEndpointsSatisfied();
    }
}
