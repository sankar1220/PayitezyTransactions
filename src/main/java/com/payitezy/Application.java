package com.payitezy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.support.GenericConversionService;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class Application {
	public final static String CONVERSION_SERVICE_BEANNAME = "conversionService";
	private static Class<Application> applicationClass = Application.class;
	public static void main(String[] args) {
		
		  SpringApplication.run(applicationClass, args);
		
	}
	/* @Override
	    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }*/
	@Bean(name = CONVERSION_SERVICE_BEANNAME)
    @Primary
    public GenericConversionService conversionService() {
        return new GenericConversionService();
    }
	
	@Bean
    @Primary
    public ObjectMapper jacksonObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }
}
