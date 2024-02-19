package com.workorders;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.convention.NameTransformers;
import org.modelmapper.convention.NamingConventions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan({"com.pj.workorders.domain"})
@ComponentScan("com.pj.workorders.web")
@EnableJpaRepositories({"com.pj.workorders.repository"})
@EnableSwagger2

public class workordersApplication {
    
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pj.workorders.web"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder().version("1.0").title("Organization API").description("Documentation Organization API v1.0").build());
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.getConfiguration().setAmbiguityIgnored(true);
        mapper.getConfiguration().setFieldMatchingEnabled(true);
        mapper.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
        mapper.getConfiguration().setDestinationNameTokenizer(NameTokenizers.CAMEL_CASE);
        mapper.getConfiguration().setDestinationNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        mapper.getConfiguration().setDestinationNameTransformer(NameTransformers.JAVABEANS_MUTATOR);
        return mapper;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(workordersApplication.class, args);
    }
}

