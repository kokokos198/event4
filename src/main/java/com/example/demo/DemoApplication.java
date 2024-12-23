package com.example.demo;

import com.example.demo.DTO.Deals_DTO;
import com.example.demo.Entity.Deals;
import com.example.demo.Mappers.Deals_Mapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

import java.util.Optional;

//@SpringBootApplication

@Configuration
@EnableAutoConfiguration
@ComponentScan
//@EnableJpaRepositories("com.example.demo.Repository")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public MultipartResolver multipartResolver() {
//        MultipartResolver mul = new StandardServletMultipartResolver();
//        return  mul;
//    }
//
//@Bean
//    public StandardServletMultipartResolver multipartResolver2() {
//        return new StandardServletMultipartResolver();
//}




}



