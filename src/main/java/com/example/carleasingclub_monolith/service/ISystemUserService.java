package com.example.carleasingclub_monolith.service;

import com.example.carleasingclub_monolith.common.result.Response;
import com.example.carleasingclub_monolith.entity.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
public interface ISystemUserService extends IService<SystemUser> {
    /***
     * @Description 登录之后返回Token
     * @author chennanjiang
     * @date 2022/5/3 20:07
     * @params [username, password, request]
     * @return com.example.carleasingclub_monolith.common.result.Response
     */
    Response login(String username, String password,String verifyCode, HttpServletRequest request);
    /***
     * @Description 根据用户名获取用户
     * @author chennanjiang
     * @date 2022/5/3 20:55
     * @params [username]
     * @return com.example.carleasingclub_monolith.entity.SystemUser
     */
    SystemUser getSystemUserByUserName(String username);
}
