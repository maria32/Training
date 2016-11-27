package com.weather;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * Created by martanase on 11/22/2016.
 */
//@Configuration
//@ComponentScan(basePackages = { "com.endava.weatherapp" })
//@ImportResource(value = { "classpath:beans.xml" })
@SpringBootApplication
@EnableAutoConfiguration
public class ApplicationStart extends SpringBootServletInitializer {

    private static Class<ApplicationStart> applicationClass = ApplicationStart.class;

    public static void main(String[] args) {

        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationStart.class);
    }
}
