package com.learn.camel.bean;

public class SampleBean {

    // this name (map) should map with the name given in the route
    public String map(String input){
       return input.replace("-","*");
    }
}
