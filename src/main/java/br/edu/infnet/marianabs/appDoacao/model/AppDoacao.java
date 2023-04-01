package br.edu.infnet.marianabs.appDoacao.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories("br.edu.infnet.marianabs.appDoacao.model.repository")
class AppDoacao {
    public static void main(String[] args) {
        SpringApplication.run(AppDoacao.class, args);
    }
}
