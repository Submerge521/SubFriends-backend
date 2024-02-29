package com.submerge.subfriends.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger使用的配置文件
 * @author Submerge
 */
@Configuration
@EnableSwagger2
//@Profile({"dev", "test"})
public class Swagger2Configuration {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 标注控制器的位置
                .apis(RequestHandlerSelectors.basePackage("com.submerge.subfriends.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 基本信息的配置，信息会在api文档上显示
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Submergeの接口文档")
                .description("接口文档")
                .termsOfServiceUrl("http://localhost:8080/hello")
                .version("1.0")
                .build();
    }
}