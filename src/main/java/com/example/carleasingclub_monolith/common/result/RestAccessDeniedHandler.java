package com.example.carleasingclub_monolith.common.result;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-04 15:04
 */

import com.example.carleasingclub_monolith.common.utils.StatusCodeEnue;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chennanjiang
 * @date Created in 2022/5/4 15:04
 * @description 访问接口没有权限时的返回类
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter out=response.getWriter();
        Response responsebean=Response.error(StatusCodeEnue.NO_PROMISSION.getCode(),StatusCodeEnue.NO_PROMISSION.getMessage());
        out.write(new ObjectMapper().writeValueAsString(responsebean));
        out.flush();
        out.close();
    }
}
