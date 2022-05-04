package com.example.carleasingclub_monolith.config;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-04-19 8:16
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chennanjiang
 * @date Created in 2022/4/19 8:16
 * @description swagger2配置文件
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径,控制器类包
                .apis(RequestHandlerSelectors.basePackage("com.example.carleasingclub_monolith.controller"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchems());
    }

    private List<SecurityContext> securityContexts(){
        //设置登录需要认证的路径
        List<SecurityContext> result=new ArrayList<>();
        result.add(getContextByPath("/hello/.*"));
        return result;

    }

    private SecurityContext getContextByPath(String pathRegex) {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result=new ArrayList<>();
        //授权范围
        AuthorizationScope authorizationScope=new AuthorizationScope("global","accessEveryThing");
        AuthorizationScope[] authorizationScopes=new AuthorizationScope[1];
        authorizationScopes[0]=authorizationScope;
        result.add(new SecurityReference("Authorization",authorizationScopes));
        return result;
    }


    private List<ApiKey> securitySchems(){
        //设置请求头信息
        List<ApiKey> result=new ArrayList<>();
        ApiKey apiKey=new ApiKey("Authorization","Authorization","Header");
        result.add(apiKey);
        return  result;
    }


    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("汽车租凭俱乐部 RESTful API接口文档")
                //创建人
                .contact(new Contact("chennanjiang", "https://gitee.com/zkboort/carleasingclub_monolith.git",  "2713594960@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("演示系统API描述")
                .build();
    }

}
