package com.sonam.webapp.jaxrs.cxf;

import com.sonam.webapp.jaxrs.Greeting;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Api("/sayHello")
@Service
public class WelcomeGreeting implements Greeting {
    private Logger logger = LoggerFactory.getLogger(WelcomeGreeting.class);

    @Override
    public String sayHello(String a) {
        logger.info("hello to {}", a);
        return "hello to " + a;
    }
}
