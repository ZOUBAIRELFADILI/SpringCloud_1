package com.ayadsec.tp1sec;

import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.http.HttpClient;

@SpringBootApplication
public class Tp1secApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tp1secApplication.class, args);
    }

}
