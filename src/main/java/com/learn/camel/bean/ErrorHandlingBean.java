package com.learn.camel.bean;

import java.util.logging.Logger;

public class ErrorHandlingBean {

    Logger logger = Logger.getLogger(ErrorHandlingBean.class.getName());

    public String getTransformedString(String input) throws Exception {
        String output;
        try {
            output = input.replace("-", "*");
        }catch (Exception ex)
        {
            logger.severe("exception while transformation" + ex.getMessage());
            throw ex;
        }
        return output;
    }
}
