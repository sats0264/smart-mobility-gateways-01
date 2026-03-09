package com.smart.mobility.smartmobilitygateway01.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

        @Bean
        public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
                return builder.routes()
                                .route("user-service-route",
                                                r -> r.path("/users/**", "/api/subscriptions/**", "/api/passes/**",
                                                                "/api/catalog/**", "/admin/users/**")
                                                                .uri("lb://user-mobility-pass-service"))
                                .route("trip-management-service-route",
                                                r -> r.path("/trips/**", "/api/trips/**", "/admin/trips/**")
                                                                .uri("lb://trip-management-service"))
                                .route("pricing-service-route", r -> r.path("/api/pricing/**", "/admin/pricing/**")
                                                .uri("lb://pricing-discount-service"))
                                .route("billing-service-route",
                                                r -> r.path("/api/payments/**", "/accounts/**",
                                                                "/admin/billing/**")
                                                                .uri("lb://billing-service"))
                                .route("notification-service-route",
                                                r -> r.path("/notifications/**", "/admin/notifications/**")
                                                                .uri("lb://notification-service"))
                                .build();
        }
}
