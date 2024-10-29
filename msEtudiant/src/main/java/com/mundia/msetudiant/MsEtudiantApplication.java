package com.mundia.msetudiant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MsEtudiantApplication {
@Bean
    WebClient webClient() {
    return WebClient.builder().build();
}
    public static void main(String[] args) {
        SpringApplication.run(MsEtudiantApplication.class, args);
    }

}
