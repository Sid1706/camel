package com.learn.camel.xml2json;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class XML2JsonTest extends CamelTestSupport{
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new XML2Json();
    }

    @Test
    public void testXML2Json()
    {

       // String expected = "{\"age\":\"123 \",\"firstName\":\"ABC\",\"lastName\":\"senior\"}";
        String request = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
                "<Employee><id>123 </id><name>ABC</name><type>senior</type></Employee>\r\n";

        final String response = (String) template.requestBody("direct:inputXML",request);
        System.out.println("response is : " + response);

      //  assertEquals(expected, response);


    }
}