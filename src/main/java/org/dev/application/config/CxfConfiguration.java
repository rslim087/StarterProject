package org.dev.application.config;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfiguration {
    private static final String URL_MAPPING = "/*";

    //the servlet is registered on "/", so the address on CXF will be "/<endpoint>"
    //if servlet was registered on "/hello", address on CXF will be "hello/<endpoint>"
    //if servlet is registered on "/bye", and address on CXF is "yo/<endpoint>", there is no way cxf can receive requests
    //because you configured it to receive requests from a servlet registered on the URLMapping, bye. 
    //Note that what precedes the path is the server DNS, which is localhost:9000, in this case.

    @Bean
    public ServletRegistrationBean<?> cxfServlet() {
        return new ServletRegistrationBean<>(new CXFServlet(), URL_MAPPING);
    }
}
