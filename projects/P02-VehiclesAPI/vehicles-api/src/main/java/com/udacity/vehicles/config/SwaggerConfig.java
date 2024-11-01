package com.udacity.vehicles.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /*Docket: Springfox abstraction for the Swagger framework,
     used to configure the behavior of the generated API documentation.*/
    @Bean
    public Docket api() {
        /*basePackage("com.example"): This specifies the package where your controllers are located,
        so Swagger can scan them and generate documentation for the exposed endpoints.*/
        /*paths(PathSelectors.any()): This enables documentation for all paths in the specified package.*/
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo()); //Turn off  the default response to customize the response
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Vehicle API",
                "This API returns some information such as the price and the location about some vehicles",
                "1.0",
                "http://www.udacity.com/tos",
                new Contact("Nedaa H.Ahmed", "www.udacity.com", "nedaa.hussein@thirdwayv.com"),
                "License of API", "http://www.cars.com/license", Collections.emptyList());
    }
}
/*Swagger provides several annotations that you can use to further enhance the API documentation:

@Api: Used at the class level to define metadata for a resource.
@ApiOperation: Describes an operation (or method) in the API.
@ApiParam: Adds metadata for parameters in methods.
@ApiResponse: Describes the response of an operation.
@ApiResponses: Groups multiple @ApiResponse annotations.*/