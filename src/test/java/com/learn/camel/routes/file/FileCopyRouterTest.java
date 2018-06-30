package com.learn.camel.routes.file;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

import java.io.File;

public class FileCopyRouterTest extends CamelTestSupport {

    @Override
    public RoutesBuilder createRouteBuilder(){
        return new FileCopyRouter();
    }

    @Test
    public void FileCopyTest() throws InterruptedException{

        Thread.sleep(5000);
        File file = new File("data/output");

        assertTrue(file.isDirectory());

        System.out.println("Total no of files in the output directory : "
                + file.listFiles().length);

        assertEquals(2, file.listFiles().length);

    }
}
