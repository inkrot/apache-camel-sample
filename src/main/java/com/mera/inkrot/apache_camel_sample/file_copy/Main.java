package com.mera.inkrot.apache_camel_sample.file_copy;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {

    public static void main(String[] args) throws Exception {
        // all new files from "data/inbox/" copy to "data/outbox/"
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("file:data/inbox?noop=true")
                        .to("file:data/outbox");
            }
        });
        context.start();
        Thread.sleep(60000);
        context.stop();
    }
}