package com.scweb.scgateway.route;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> projectServiceRouter() {
        return GatewayRouterFunctions
                .route("project-service")
                .route(RequestPredicates.path("/api/project"),
                        HandlerFunctions.http("http://localhost:8080"))
                .build();
    }
}
