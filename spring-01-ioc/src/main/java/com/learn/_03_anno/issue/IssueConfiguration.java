package com.learn._03_anno.issue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learn._03_anno.issue")
public class IssueConfiguration {
    @Bean
    public Person administrator(){
        Person person = new Person();
        person.setName("john");
        return person;
    }

    @Bean
    public YPerson y1(@Value("paul") String name){
        YPerson yperson = new YPerson();
        yperson.setName(name);
        return yperson;
    }

    @Bean
    public YPerson y2(@Value("john") String name){
        YPerson yperson = new YPerson();
        yperson.setName(name);
        return yperson;
    }
}

