package com.example.oss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SystemPropertyExampleApplication {

    public static void main(String[] args) {
    	
        ConfigurableApplicationContext context = SpringApplication.run(SystemPropertyExampleApplication.class, args);

        // Get the user's home directory
        String userHome = context.getBean("getUserHome", String.class);
        System.out.println("User's Home Directory: " + userHome);

        // Get the Java version
        String javaVersion = context.getBean("getJavaVersion", String.class);
        System.out.println("Java Version: " + javaVersion);

        context.close();
    }
}

