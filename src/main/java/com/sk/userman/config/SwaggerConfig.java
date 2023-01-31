/**
 * -----------------------------------
 *  Copyright (c) 2021-2022
 *  All rights reserved, Designed By www.linfeng.tech
 *  林风社交论坛商业版本请务必保留此注释头信息
 *  商业版授权联系技术客服	 QQ:  3582996245
 *  严禁分享、盗用、转卖源码或非法牟利！
 *  版权所有 ，侵权必究！
 * -----------------------------------
 */
package com.sk.userman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {



    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sk.userman.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(getParameterList());

    }

    private List<Parameter> getParameterList(){
        ParameterBuilder parameterBuilder = new ParameterBuilder();
        ArrayList<Parameter> parameters = new ArrayList<>();

        parameterBuilder.name("token").description("token令牌").modelRef(new ModelRef("String"))
                .parameterType("header").required(false).build();
        parameters.add(parameterBuilder.build());
        return  parameters;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("用户管理")
                .description("用户管理接口文档")
                .contact(new Contact("userman","http://localhost:8080/swagger-ui.html","11111@163.com"))
                .version("1.1.0")
                .build();

    }
}