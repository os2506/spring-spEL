package com.example.oss.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.oss.entity.Person;

@Configuration
public class BeanPersonConfig {

    @Bean(name = "personBean")
    Person person() {
        Person prs = new Person();
        prs.setName("Name");
        prs.setAge(30);
        return prs;
    }

}
//Bean property
//Mathematical operations
//Conditional operators
//access to variable from the context spring
//configure dev or prod environnement / Determine the active Spring profile
//SystemProperty Config 
//Logic Constants 