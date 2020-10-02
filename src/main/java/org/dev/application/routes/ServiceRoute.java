package org.dev.application.routes;

import java.io.InputStream;

import javax.activation.DataHandler;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import org.apache.camel.Processor;

@Component
public class ServiceRoute extends RouteBuilder {
    
    @Override
    public void configure() throws Exception {
        from("cxf:bean:greeting-ws").routeId("greeting-ws")
        .process(new Processor(){
            public void process(Exchange exchange) throws Exception {
                System.out.println(exchange.getIn().getBody());
                DataHandler dataHandler = simple("${body[3]}").evaluate(exchange, DataHandler.class);
                System.out.println(dataHandler.getContentType());

                exchange.getIn().setBody(dataHandler);
            }	
        })
        .log("hello from camel").end();
    }

}
