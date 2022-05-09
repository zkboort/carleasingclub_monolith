package com.example.carleasingclub_monolith.config;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-03 21:08
 */

import com.example.carleasingclub_monolith.common.filters.JwtAuthencationTokenFilter;
import com.example.carleasingclub_monolith.common.result.RestAccessDeniedHandler;
import com.example.carleasingclub_monolith.common.result.RestAuthorizationEntryPoint;
import com.example.carleasingclub_monolith.entity.SystemUser;
import com.example.carleasingclub_monolith.service.impl.SystemUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author chennanjiang
 * @date Created in 2022/5/3 21:08
 * @description Security认证授权框架配置类
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SystemUserServiceImpl systemUserService;
    @Autowired
    private RestAccessDeniedHandler restAccessDeniedHandler;
    @Autowired
    private RestAuthorizationEntryPoint restAuthorizationEntryPoint;

    /**
     * @Description 重写UserDetailService的根据用户名获取用户信息方法
     * @author chennanjiang
     * @date 2022/5/3 21:14
     * @params []
     * @return org.springframework.security.core.userdetails.UserDetailsService
     */
    @Bean
    @Override
    public UserDetailsService userDetailsService(){
        return username -> {
            SystemUser systemUser=systemUserService.getSystemUserByUserName(username);
            if(systemUser!=null){
                return systemUser;
            }
            return null;
        };
    }

    /**
     * @Description 重写了根据用户名获取用户的方法后，我们使用登录逻辑时，使用重写的UserDetailService
     * @author chennanjiang
     * @date 2022/5/3 21:17
     * @params [auth]
     * @return void
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
       return  new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthencationTokenFilter jwtAuthencationTokenFilter(){
      return new JwtAuthencationTokenFilter();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略拦截所有
        web.ignoring().antMatchers("/**");

    }


    /**
     * @Description 权限框架完整配置
     * @author chennanjiang
     * @date 2022/5/3 21:21
     * @params [http]
     * @return void
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf()
                .disable()
                //基于Token不需要session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                //需要拦截请求路径,所有需要
                .anyRequest()
                .authenticated()
                .and()
                .headers()
                .cacheControl();
        //添加jwt 登录授权过滤器
        http.addFilterBefore(jwtAuthencationTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        //自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restAccessDeniedHandler)
                .authenticationEntryPoint(restAuthorizationEntryPoint);

    }
}
