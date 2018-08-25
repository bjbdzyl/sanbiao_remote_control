package com.sgai.meter.transmission.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {


    @Bean
    public Docket createRestApi() {
    	//添加head参数start  
        ParameterBuilder tokenPar = new ParameterBuilder();  
        List<Parameter> pars = new ArrayList<Parameter>();  
        tokenPar.name("Auth-Token").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();  
        pars.add(tokenPar.build());  
    	
        String[] basePackages = new String[] {"com.sgai.meter.transmission.web", 
        		"com.sgmart.company.web",
        		"com.sgmart.code.web",
        		"com.sgmart.upload.web"};
        Predicate<RequestHandler> selector = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
            	String pkName = input.declaringClass().getPackage().getName();
            	for (String basePackage : basePackages) {
            		if (pkName.startsWith(basePackage)) {
            			return true;
            		}
            	}
            	return false;
            }
          };
        
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(selector)
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("生态城三表数据采集 RESTful APIs")
                .description("生态城三表数据采集管理平台api接口文档")
                .version("1.0")
                .build();
    }

}
