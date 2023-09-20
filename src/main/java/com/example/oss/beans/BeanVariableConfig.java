package com.example.oss.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanVariableConfig {
	
	
    @Bean
    String myVariable() {
        return "Hello from myVariable!";
    }

}
