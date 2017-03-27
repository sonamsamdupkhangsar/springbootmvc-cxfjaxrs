package com.sonam.webapp;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WelcomeGreetingInteg.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WelcomeGreetingInteg {

    @LocalServerPort
    private int port;
    @Test
    public void testHelloRequest() throws Exception {
        WebClient wc = WebClient.create("http://localhost:" + port + "/services/helloservice");
        wc.accept("text/plain");

        // HelloServiceImpl1
        wc.path("sayHello").path("ApacheCxfUser");
        String greeting = wc.get(String.class);
        Assert.assertEquals("Hello ApacheCxfUser, Welcome to CXF RS Spring Boot World!!!", greeting);

        // Reverse to the starting URI
        wc.back(true);

        // HelloServiceImpl2
        wc.path("sayHello2").path("ApacheCxfUser");
        greeting = wc.get(String.class);
        Assert.assertEquals("Hello2 ApacheCxfUser, Welcome to CXF RS Spring Boot World!!!", greeting);
    }

}