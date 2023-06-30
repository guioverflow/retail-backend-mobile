package com.atacadista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class AtacadistaApp {

    public static void main(String[] args) {
        SpringApplication.run(AtacadistaApp.class, args);
    }

    @GetMapping
    public List<String> routes() {
        return List.of("teste", "produto");
    }
}
