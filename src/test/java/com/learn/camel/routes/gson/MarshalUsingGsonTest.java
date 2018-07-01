package com.learn.camel.routes.gson;

import com.learn.camel.domain.Employee;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import static org.junit.Assert.*;

public class MarshalUsingGsonTest extends CamelTestSupport{

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new MarshalUsingGson();
    }

    @Test
    public void  TestGsonMarshal()
    {
      String output = "{\"firstName\":\"amit\",\"age\":\"12\",\"lastName\":\"gupta\"}";

      Employee employee = new Employee();
      employee.setAge("12");
      employee.setFirstName("amit");
      employee.setLastName("gupta");

      String employyJson =  template.requestBody("direct:input", employee, String.class);
      assertEquals(output,employyJson);
    }
}