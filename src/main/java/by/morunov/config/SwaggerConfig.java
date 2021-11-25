package by.morunov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Alex Morunov
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String SEARCH = "spring-rest-swagger";

    @Bean
    public Docket myApp() {
        return new Docket(DocumentationType.SWAGGER_2).groupName(SEARCH)
                .apiInfo(apiInfo()).tags(new Tag(SEARCH, "spring-rest-swagger API"));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(SEARCH).build();
    }
}
