package com.pf.miserver.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
/** 是否打开swagger **/
@ConditionalOnExpression("'${swagger.enable}' == 'true'")
public class SwaggerConfig {
	
    
	@Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.pf.miserver.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //http://localhost:8081/swagger-ui.html文件访问
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("sbc order api")
                .description("sbc order api")
                .termsOfServiceUrl("http://192.168.1.86:8081")
                .contact("crossoverJie")
                .version("1.0.0")
                .build();
    }
    
}