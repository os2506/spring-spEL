package com.example.oss.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemPropertyConfig {

    @Value("#{systemProperties['user.home']}")
    private String userHome;

    @Value("#{systemProperties['java.version']}")
    private String javaVersion;

    @Bean
    String getUserHome() {
        return userHome;
    }

    @Bean
    String getJavaVersion() {
        return javaVersion;
    }
}
