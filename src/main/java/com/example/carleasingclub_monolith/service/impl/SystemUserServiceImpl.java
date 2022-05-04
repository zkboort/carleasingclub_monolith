package com.example.carleasingclub_monolith.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.example.carleasingclub_monolith.common.result.Response;
import com.example.carleasingclub_monolith.common.utils.JwtTokenUtil;
import com.example.carleasingclub_monolith.common.utils.StatusCodeEnue;
import com.example.carleasingclub_monolith.entity.SystemUser;
import com.example.carleasingclub_monolith.mapper.SystemUserMapper;
import com.example.carleasingclub_monolith.service.ISystemUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
@Service
public class SystemUserServiceImpl extends ServiceImpl<SystemUserMapper, SystemUser> implements ISystemUserService {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private SystemUserMapper systemUserMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    //token头部信息
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    /***
     * @Description 登录之后返回Token
     * @author chennanjiang
     * @date 2022/5/3 20:08
     * @params [username, password, request]
     * @return com.example.carleasingclub_monolith.common.result.Response
     */
    @Override
    public Response login(String username, String password, String verifyCode,HttpServletRequest request) {
        //获取验证码
        String captcha=request.getSession().getAttribute("captcha").toString();
        if(StringUtils.isEmpty(verifyCode)|| !captcha.equalsIgnoreCase(verifyCode)){
            return Response.error("验证码错误，请重新输入！");
        }
        //登录
        UserDetails userDetails=userDetailsService.loadUserByUsername(username);
        if(userDetails==null|| passwordEncoder.matches(password,userDetails.getPassword())){
            return Response.error(StatusCodeEnue.LOGIN_FAIL.getCode(),StatusCodeEnue.LOGIN_FAIL.getMessage());
        }
        if(!userDetails.isEnabled()){
            return Response.error(StatusCodeEnue.ACCOUNT_ENABLED.getCode(),"账号被禁用！请联系管理员");
        }
        //更新Security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        //放入Security全局里面
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //根据用户信息拿到令牌
        String token=jwtTokenUtil.getToken(userDetails);
        Map<String,String> tokenMap=new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHeader",tokenHeader);
        return Response.success("登录成功",tokenMap);
    }

    /***
     * @Description 根据用户名获取用户
     * @author chennanjiang
     * @date 2022/5/3 20:57
     * @params [username]
     * @return com.example.carleasingclub_monolith.entity.SystemUser
     */
    @Override
    public SystemUser getSystemUserByUserName(String username) {
        return systemUserMapper.selectOne(new QueryWrapper<SystemUser>().eq("username",username).eq("enabled",true));
    }
}
