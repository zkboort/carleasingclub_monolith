package com.example.carleasingclub_monolith.controller;/**
 * @Description:
 * @author chennanjiang
 * @date 2022-05-03 19:56
 */

import com.example.carleasingclub_monolith.common.commonBean.param.SystemUserLoginParams;
import com.example.carleasingclub_monolith.common.result.Response;
import com.example.carleasingclub_monolith.entity.SystemUser;
import com.example.carleasingclub_monolith.service.impl.SystemUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author chennanjiang
 * @date Created in 2022/5/3 19:56
 * @description 登录功能接口
 */
@RestController
@Api(tags = "LoginController")
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private SystemUserServiceImpl systemUserService;

    @ApiOperation(value = "登录之后返回token")
    @PostMapping("/systemUserLogin")
    public Response login(SystemUserLoginParams systemUserLoginParams, HttpServletRequest request){
         return systemUserService.login(systemUserLoginParams.getUsername(),systemUserLoginParams.getPassword(),request);
    }

    @ApiOperation(value = "获取当前登录用户信息")
    @PostMapping("/getSysUserInfo")
    public SystemUser getSystemUserInfo(Principal principal){
        if(principal==null){
            return null;

        }
        String username=principal.getName();
        //根据用户名查询用户
        SystemUser systemUser=systemUserService.getSystemUserByUserName(username);
        systemUser.setPassword(null);
        return systemUser;
    }

    @ApiModelProperty(value = "退出登录")
    @PostMapping("/systemUserLogout")
    public Response logout(){
         return Response.success("退出成功！");
    }
}
