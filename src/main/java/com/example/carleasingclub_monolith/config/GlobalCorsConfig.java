package com.example.carleasingclub_monolith.config;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-01 13:48
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author chennanjiang
 * @date Created in 2022/5/1 13:48
 * @description 全局配置
 */
@Configuration
public class GlobalCorsConfig {
    /***
     * @Description 使用过滤器 配置跨域支持
     * @author chennanjiang
     * @date 2022/5/1 13:50
     * @params []
     * @return org.springframework.web.cors.CorsConfiguration
     */
    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration config=new CorsConfiguration();
        //允许所有域名进行跨域调用
        config.addAllowedOrigin("*");
        //运行跨域发送cookie
        config.setAllowCredentials(true);
        //放行全部原始头信息
        config.addAllowedHeader("*");
        //允许所有请求方法跨域调用
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",config);
        return new CorsFilter(source);
    }
}
