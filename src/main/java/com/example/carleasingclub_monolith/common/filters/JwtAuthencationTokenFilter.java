package com.example.carleasingclub_monolith.common.filters;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-03 21:33
 */

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chennanjiang
 * @date Created in 2022/5/3 21:33
 * @description jwt授权过滤器
 */
public class JwtAuthencationTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
}
