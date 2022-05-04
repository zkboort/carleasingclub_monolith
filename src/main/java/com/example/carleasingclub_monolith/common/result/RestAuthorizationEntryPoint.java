package com.example.carleasingclub_monolith.common.result;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-04 10:13
 */

import com.example.carleasingclub_monolith.common.utils.StatusCodeEnue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chennanjiang
 * @date Created in 2022/5/4 10:13
 * @description 未登录，token失效时，访问接口返回的结果
 */
@Component
public class RestAuthorizationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        Response responseBean=Response.error(StatusCodeEnue.NO_LOGIN.getCode(),StatusCodeEnue.NO_LOGIN.getMessage());
        out.write(new ObjectMapper().writeValueAsString(responseBean));
        out.flush();
        out.close();
    }
}
