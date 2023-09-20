package com.example.oss.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileUploadConfig {

    @Value("${upload.max-size.development}")
    private long maxUploadSizeForDev;

    @Value("${upload.max-size.production}")
    private long maxUploadSizeForProd;
    
    @Autowired 
    Environment environment;

    @Bean
    CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        
        // Determine the maximum upload size based on the active Spring profile
        if (isDevelopmentProfile()) {
            resolver.setMaxUploadSize(maxUploadSizeForDev);
        } else {
            resolver.setMaxUploadSize(maxUploadSizeForProd);
        }
        
        return resolver;
    }

    // Determine the active Spring profile
    public boolean isDevelopmentProfile() {
        // You can use Spring's Environment or other mechanisms
        return environment.getActiveProfiles()[0].equalsIgnoreCase("development");
    }
}
