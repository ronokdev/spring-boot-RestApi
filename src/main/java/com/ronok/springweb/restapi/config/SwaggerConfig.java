package com.ronok.springweb.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig
{
    @Bean
    public Docket productApi() // A Docket Bean that is required by Spring fox in order to Customise our Swagger
    {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.ronok.springweb.restapi.controllers")) //// swagger will scan through only the given base package
                .paths(PathSelectors.regex("/products.*")) // swagger will document only the endpoints start's with /products within the given controller path
                .build();
    }
}
