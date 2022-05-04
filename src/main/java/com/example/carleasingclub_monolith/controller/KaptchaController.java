package com.example.carleasingclub_monolith.controller;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-04 16:23
 */

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author chennanjiang
 * @date Created in 2022/5/4 16:23
 * @description 验证码接口
 */
@RestController
@RequestMapping("/restKaptcha")
public class KaptchaController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @ApiOperation(value = "验证码")
    @GetMapping(value = "/kaptcha",produces = "image/jpeg")
    public void kaptcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //返回一个图片(image,jpeg)，通过流传输，对于响应头需要做处理,定义返回类型为jpeg图片
        //禁止缓存
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        //设置响应格式为png图片
        response.setContentType("image/png");


        //生成验证码-------------------------------------------------------------------------------begin
        //验证码文本内容
        String text=defaultKaptcha.createText();
        System.out.println("验证码内容"+text);
        //将验证码内容放入Session
        request.getSession().setAttribute("captcha",text);

        //验证码图片
        BufferedImage image=defaultKaptcha.createImage(text);
        //输出图片
        ServletOutputStream outputStream=response.getOutputStream();
        ImageIO.write(image,"jpg",outputStream);
        outputStream.flush();
        outputStream.close();

        //生成验证码---------------------------------------------------------------------------------end
    }
}
