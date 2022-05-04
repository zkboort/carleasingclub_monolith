package com.example.carleasingclub_monolith.common.filters;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-03 21:33
 */

import com.example.carleasingclub_monolith.common.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
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
public class JwtAuthencationTokenFilter extends OncePerRequestFilter{
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader=request.getHeader(tokenHeader);
        //判断请求头，存在token
        if(authHeader!=null &&tokenHeader.startsWith(tokenHead)){
            //截取token
            String authToken=authHeader.substring(tokenHead.length());
            //jwt根据token获取用户名
            String username=jwtTokenUtil.getUsenameByToken(authToken);
            //判断 未登录处理
            if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
                //登录
                UserDetails userDetails=userDetailsService.loadUserByUsername(username);
                //判断token是否有效,有效重新加入到用户对象
                if(jwtTokenUtil.validateToken(authToken,userDetails)){
                    UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }
        }
        //过来链放行请求
        filterChain.doFilter(request,response);
    }
}
