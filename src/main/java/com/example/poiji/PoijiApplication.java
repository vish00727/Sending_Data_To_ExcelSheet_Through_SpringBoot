package com.example.poiji;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
public class PoijiApplication {
    public static void main(String[] args) {
		SpringApplication.run(PoijiApplication.class, args);
	}


}
