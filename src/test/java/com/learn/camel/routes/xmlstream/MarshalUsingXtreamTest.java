package com.learn.camel.routes.xmlstream;

import com.learn.camel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarshalUsingXtreamTest extends CamelTestSupport {

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingXtream();
    }

    @Test
    public void testMarshal()
    {
        String input = "12,Sumit,Shenoy";

        Employee e = new Employee();
        e.setAge("12");
        e.setFirstName("Sumit");
        e.setLastName("Shenoy");

        Employee actualEmployee = (Employee)template.requestBody("direct:inputString", input);
        assertEquals(e.getAge(), actualEmployee.getAge());
        assertEquals(e.getFirstName(),actualEmployee.getFirstName());
        assertEquals(e.getLastName(),actualEmployee.getLastName());

    }
}