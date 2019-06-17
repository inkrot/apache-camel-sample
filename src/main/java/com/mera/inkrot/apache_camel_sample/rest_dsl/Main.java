package com.mera.inkrot.apache_camel_sample.rest_dsl;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.http.HttpComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.util.ExchangeHelper;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                restConfiguration().component("restlet").host("localhost").port(9090).bindingMode(RestBindingMode.auto);

                rest("/hello/")
                        .get().outType(String.class)
                        .to("direct:hello");
                /*rest("/order/")
                        .get().type(Long.class).outType(Order.class)
                        .to("direct:order");*/
            }
        });
        context.start();
    }
}
