package service.gateway;

import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    // @Bean
    // public RouteLocator createRoutes(RouteLocatorBuilder rlb){
    //     return rlb.routes().route(r -> r.path("/api/custumers**").uri("lb://CUSTUMER-SERVICE")).build();
    // }
    //Pour creer des routes statiques et gérer le loadbalancing
    
    @Bean
    public DiscoveryClientRouteDefinitionLocator routeConfig(
        ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp
    )
{
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }
    //Ce bean va aller recuperer tous les clients eureka en utilisant ReactiveDiscoveryClient et avec l'objet
        // DiscoverLocatorPoperties on recupère tous les proprietés du client y compris les adresses ip. Donc à
        // chaque fois qu'un micros service s'enregistre une route lui aussitôt réservée  
        //url de test http://localhost:8008/CUSTUMER-SERVICE/custumers
}
