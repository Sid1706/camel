package com.learn.camel.routes.gson;

import com.learn.camel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnMarshalUsingGsonTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new UnMarshalUsingGson();
    }

    @Test
    public void UnMarshalTest()
    {
        String employeeJson = "{\"firstName\":\"amit\",\"age\":\"12\",\"lastName\":\"gupta\"}";

        Employee employee = (Employee)template.requestBody("direct:input", employeeJson);


        System.out.println((employee.getAge()));
    }
}