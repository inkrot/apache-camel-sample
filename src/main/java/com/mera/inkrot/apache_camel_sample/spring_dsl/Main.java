package com.mera.inkrot.apache_camel_sample.spring_dsl;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws Exception {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CamelContext camelContext = SpringCamelContext.springCamelContext(appContext, false);
        try {
            ProducerTemplate template = camelContext.createProducerTemplate();
            camelContext.start();
            template.sendBody("activemq:test.queue", "Hello World");
        } finally {
            camelContext.stop();
        }
    }
}
