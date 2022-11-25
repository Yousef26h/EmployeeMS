package com.example.employeems;

import com.example.employeems.exception.EmployeeServiceExceptionMsgs;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.ObjectInputFilter;

@SpringBootApplication
@EnableSwagger2
public class EmployeeMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeMsApplication.class, args);
    }


    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
