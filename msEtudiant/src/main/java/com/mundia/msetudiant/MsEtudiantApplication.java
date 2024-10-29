package com.mundia.msetudiant;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@SpringBootApplication
public class MsEtudiantApplication {
    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder(){
    HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
    return WebClient.builder()
            .clientConnector(new ReactorClientHttpConnector(httpClient));
    }
    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder){
        return webClientBuilder.build();
    }
    public static void main(String[] args) {
        SpringApplication.run(MsEtudiantApplication.class, args);
    }

}
