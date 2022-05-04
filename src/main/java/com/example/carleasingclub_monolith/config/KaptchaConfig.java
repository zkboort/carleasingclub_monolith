package com.example.carleasingclub_monolith.config;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-04 15:39
 */

import com.google.code.kaptcha.impl.DefaultKaptcha;

import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @author chennanjiang
 * @date Created in 2022/5/4 15:39
 * @description 谷歌验证码的配置类
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();

        Properties properties=new Properties();
        //验证码是否带边框 yes
        properties.setProperty("kaptcha.border", "yes");
        //设置边框的颜色
        properties.setProperty("kaptcha.border.color","105,179,90");
        //验证码
        properties.setProperty("kaptcha.session.key","code");
        //验证码字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "black");
        //验证码整体宽度
        properties.setProperty("kaptcha.image.width", "100");
        //验证码整体高度
        properties.setProperty("kaptcha.image.height", "40");
        //文字个数
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        //文字大小
        properties.setProperty("kaptcha.textproducer.font.size","30");
        //文字随机字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        //文字距离
        properties.setProperty("kaptcha.textproducer.char.space","4");
        //干扰线颜色
        properties.setProperty("kaptcha.noise.color","green");
        Config config=new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;

    }
}
