package com.springboot.vault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootandVaultApplication {

    @Value("${secret}")
    private String secret;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootandVaultApplication.class, args);
    }

    @GetMapping("/s")
    public String getSecret() {
        return this.secret;
    }
}
