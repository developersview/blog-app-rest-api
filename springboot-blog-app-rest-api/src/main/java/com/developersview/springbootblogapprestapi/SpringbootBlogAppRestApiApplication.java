package com.developersview.springbootblogapprestapi;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Blog App REST API",
                description = "SpringBoot Blog App REST APIs Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Pranoy Chakraborty",
                        email = "pcslg1998@gmail.com",
                        url = "https://www.linkedin.com/in/pranoy-chakraborty/"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://github.com/developersview/blog-app-rest-api/blob/master/LICENSE"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "SpringBoot Blog REST API Documentation",
                url = "https://github.com/developersview/blog-app-rest-api"
        )
)
public class SpringbootBlogAppRestApiApplication {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBlogAppRestApiApplication.class, args);
    }
}
