package com.example.carleasingclub_monolith.config;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-04-27 11:28
 */

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Collections;

/**
 * @author chennanjiang
 * @date Created in 2022/4/27 11:28
 * @description  mybatisPlus配置
 */
@Configuration
@EnableTransactionManagement
@MapperScan("com.example.carleasingclub_monolith.mapper")
public class MyBatisPlusConfig {
    /**
     * @Description 分页插件
     * @author chennanjiang
     * @date 2022/4/27 11:29
     * @params * @Param null:
     * @return * @return: null
     */
    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor(){
        PaginationInnerInterceptor paginationInnerInterceptor=new PaginationInnerInterceptor();
        //设置最大单页限制数量，默认500条 -1不受限制
        paginationInnerInterceptor.setMaxLimit(-1L);
        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        //开启count的jion优化，只针对部分left jion
        paginationInnerInterceptor.setOptimizeJoin(true);
        return paginationInnerInterceptor;
    }
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.setInterceptors(Collections.singletonList(paginationInnerInterceptor()));
        return mybatisPlusInterceptor;
    }
}
