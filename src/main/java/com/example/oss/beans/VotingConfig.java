package com.example.oss.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.example.oss.entity.Person;

@Configuration
@PropertySource("classpath:application.properties")
public class VotingConfig {

    @Value("${voting.age.limit}")
    private int votingAgeLimit;
   
    @Bean
    Person person() {
        Person person = new Person();
        person.setAge(16);

        // Check if the age is greater than or equal to the voting age limit
        if (person.getAge() >= votingAgeLimit) {
            person.setEligibleToVote(true);
        } else {
            person.setEligibleToVote(false);
        }

        return person;
    }
}

