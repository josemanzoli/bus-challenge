package com.manzoli.bus.route;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author jmanzol
 * @since 1.0-SNAPSHOT
 * Spring Boot main class. This class is called to initiate the Spring Boot Application itself.
 *
 */
@SpringBootApplication(scanBasePackages = "com.manzoli.bus.route")
@EnableSwagger2
public class Application {

	/** The main method to start the Spring Boot Application */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket busChallengeApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api.*"))
                .build()
                .pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Bus challenge web project")
                .description("Composed by one GET endpoint to return a JSON response with information about direct routes between Routes and Stations.")
                .contact(new Contact("Jose Luiz Manzoli", null, "josemanzoli@gmail.com"))
                .version("2.0")
                .build();
    }
}
