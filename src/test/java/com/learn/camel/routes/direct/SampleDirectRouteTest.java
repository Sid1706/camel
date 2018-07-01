package com.learn.camel.routes.direct;

import org.apache.camel.Exchange;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class SampleDirectRouteTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder() {
        return new SampleDirectRoute();
    }

    @Test
    public void SamepleDirectTest() throws InterruptedException {
        template.sendBody("direct:sampleInput",
                "3483234, Sumit Sehnoy, Bangalore");
        Thread.sleep(5000);

        File file = new File("sampleOutput");
        assertEquals(2, file.listFiles().length);

        Exchange exchange = consumer.receive("file:sampleOutput");
        assertEquals(exchange.getIn().getHeader("CamelFileName"),"output.txt");

        file.delete();
    }
}