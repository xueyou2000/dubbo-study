package com.xueyou.studyproject.dubbo.account.config.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
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

/**
 * Swagger配置
 *
 * @author chendong
 * @version V1.0.0
 * @since 2020/9/25 1:43 下午
 */
@Data
@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfig {

    private String title;
    private String description;
    private String version;
    private String name;
    private String email;

    private ApiInfo apiInfo() {
        Contact contact = new Contact(name, null, email);
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .contact(contact)
                .version(version)
                .build();
    }

    @Bean
    public Docket customDocket() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        ParameterBuilder languagePar = new ParameterBuilder();
        languagePar.name("Accept-Language").description("语言").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        pars.add(languagePar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .globalOperationParameters(pars)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.xueyou.studyproject.dubbo.account.controller"))
                .build();
    }




}
