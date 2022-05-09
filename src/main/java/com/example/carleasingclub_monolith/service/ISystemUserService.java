package com.example.carleasingclub_monolith.service;

import com.example.carleasingclub_monolith.common.result.Response;
import com.example.carleasingclub_monolith.entity.SystemUser;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
public interface ISystemUserService extends IService<SystemUser> {
    /**
     * @Description 登录之后返回Token
     * @author chennanjiang
     * @date 2022/5/3 20:07
     * @params [username, password, request]
     * @return com.example.carleasingclub_monolith.common.result.Response
     */
    Response login(String username, String password,String verifyCode, HttpServletRequest request);

    /**
     * @Description 根据用户名获取用户
     * @author chennanjiang
     * @date 2022/5/3 20:55
     * @params [username]
     * @return com.example.carleasingclub_monolith.entity.SystemUser
     */
    SystemUser getSystemUserByUserName(String username);

    /***
     * @Description  添加单个用户
     * @author chennanjiang
     * @date 2022/5/7 19:05
     * @params [user]
     * @return int
     */
    int addSystemUser(SystemUser user);

    /***
     * @Description 查询所有用户
     * @author chennanjiang
     * @date 2022/5/7 19:27
     * @params []
     * @return java.util.List<com.example.carleasingclub_monolith.entity.SystemUser>
     */
    List<SystemUser> getAllUser();

    /**
     * @Description 根据用户id列表批量查询
     * @author chennanjiang
     * @date 2022/5/7 20:04
     * @params [ids]
     * @return java.util.List<com.example.carleasingclub_monolith.entity.SystemUser>
     */
    List<SystemUser> queryList(List ids);

    /***
     * @Description  根据用户Id修改用户信息
     * @author chennanjiang
     * @date 2022/5/7 21:10
     * @params [user]
     * @return int
     */
    int updateUserById(SystemUser user);

    /***
     * @Description 根据用户Id删除用户
     * @author chennanjiang
     * @date 2022/5/8 20:19
     * @params [userId]
     * @return int
     */
    int deleteUserById(int userId);
}
