package com.sgai.meter.transmission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@SpringBootApplication
@ServletComponentScan
@EnableSwagger2
public class MeterTransmissionApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
        SpringApplication.run(MeterTransmissionApplication.class, args);
    }
}
