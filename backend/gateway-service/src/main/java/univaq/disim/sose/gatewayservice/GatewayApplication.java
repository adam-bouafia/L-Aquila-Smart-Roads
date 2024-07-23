package univaq.disim.sose.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * Main class for the Gateway Service application.
 * This application acts as an API Gateway using Spring Cloud Gateway.
 */
@SpringBootApplication
public class GatewayApplication {

    /**
     * Main method to run the Spring Boot application.
     * 
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * Bean definition for DiscoveryClientRouteDefinitionLocator.
     * This bean configures dynamic route definitions based on services registered
     * in the discovery client.
     * 
     * @param rdc the reactive discovery client used for service discovery
     * @param dlp the discovery locator properties for configuring the locator
     * @return a DiscoveryClientRouteDefinitionLocator instance
     */
    @Bean
    DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc,
            DiscoveryLocatorProperties dlp) {
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }
}
