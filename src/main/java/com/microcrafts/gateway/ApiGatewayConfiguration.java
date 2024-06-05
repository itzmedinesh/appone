package com.microcrafts.gateway;

import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouterFunction routeLocator() {
        return RouterFunctions.route(RequestPredicates.path("/v1/albums"), HandlerFunctions.http("http://ec2-54-83-140-26.compute-1.amazonaws.com:8080/albums"));
    }

}
