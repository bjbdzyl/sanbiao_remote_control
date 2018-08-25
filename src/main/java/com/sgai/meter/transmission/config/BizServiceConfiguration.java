package com.sgai.meter.transmission.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.sgai.meter.transmission.service",
		"com.sgmart.code.service",
		"com.sgmart.auth.user.service",
		"com.sgmart.company.service"})
public class BizServiceConfiguration {
	
}
