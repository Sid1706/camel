package com.learn.camel.processor;

import com.learn.camel.domain.Employee;
import org.apache.camel.Exchange;

import java.util.StringTokenizer;

public class CustomProcessorXstream implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {

        String inputEmployeeStting = exchange.getIn().getBody().toString();
        StringTokenizer tokenizer = new StringTokenizer(inputEmployeeStting, ",");

        Employee employee = new Employee();

        while(tokenizer.hasMoreElements()){
            employee.setAge((String) tokenizer.nextElement());
            employee.setFirstName((String) tokenizer.nextElement());
            employee.setLastName((String) tokenizer.nextElement());
        }
        exchange.getIn().setBody(employee);

    }
}
