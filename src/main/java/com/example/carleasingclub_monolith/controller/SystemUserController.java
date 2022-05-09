package com.example.carleasingclub_monolith.controller;


import com.example.carleasingclub_monolith.common.result.Response;
import com.example.carleasingclub_monolith.common.utils.StatusCodeEnue;
import com.example.carleasingclub_monolith.entity.SystemUser;
import com.example.carleasingclub_monolith.service.impl.SystemUserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
@RestController
@RequestMapping("/systemUser")
@Api("系统用户Rest")
public class SystemUserController {
    @Autowired
    private SystemUserServiceImpl systemUserService;

    @ApiOperation(value = "添加单个系统用户")
    @PostMapping("/addSystemUser")
    public Response addSystemUser(SystemUser user){
        int number=systemUserService.addSystemUser(user);
        if(number==0){
            return Response.error(StatusCodeEnue.ADD_FAIL.getCode(),StatusCodeEnue.ADD_FAIL.getMessage());
        }
        return Response.success("新增成功！");
    }

    @ApiOperation("查询所有系统用户")
    @GetMapping("/getAllSystemUser")
    public Response getAllUser(){
        List<SystemUser> userlist=systemUserService.getAllUser();
        if(userlist==null){
            return Response.error(StatusCodeEnue.QUERY_FAIL.getCode(), StatusCodeEnue.QUERY_FAIL.getMessage());
        }
        return Response.success("查询成功!",userlist);
    }

    @ApiOperation("根据用户名查询系统用户")
    @GetMapping("/getUserByUserName")
    public Response getUserByUserName(String username){
        SystemUser user=systemUserService.getSystemUserByUserName(username);
        if(user==null){
            return Response.error(StatusCodeEnue.QUERY_FAIL.getCode(),StatusCodeEnue.DELETE_FAIL.getMessage());
        }
        return Response.success("查询成功！",user);
    }

    @ApiOperation("根据用户id列表批量查询")
    @GetMapping("/getSystemUserByIds")
    public Response getUserByIds(List ids){
        List<SystemUser> users=systemUserService.queryList(ids);
        if(users==null){
            return Response.error(StatusCodeEnue.QUERY_FAIL.getCode(),StatusCodeEnue.QUERY_FAIL.getMessage());
        }
        return Response.success("查询成功！");
    }

    @ApiOperation("根据用户id修改用户信息")
    @PostMapping("/updateSystemUserById")
    public Response updateUserById(SystemUser user){
        int number=systemUserService.updateUserById(user);
        if(number==0){
            return Response.error(StatusCodeEnue.UPDATE_FAIL.getCode(), StatusCodeEnue.UPDATE_FAIL.getMessage());
        }
        return Response.success("修改成功！");
    }

    /***
     * @Description 根据用户的id删除用户
     * @author chennanjiang
     * @date 2022/5/8 20:13
     * @params []
     * @return com.example.carleasingclub_monolith.common.result.Response
     */
    @ApiOperation("根据用户的id删除用户")
    @DeleteMapping("/deleteUserById")
    public Response deleteUserById(int userId){
        int number=systemUserService.deleteUserById(userId);
        if(number==0){
            return Response.error(StatusCodeEnue.DELETE_FAIL.getCode(), StatusCodeEnue.DELETE_FAIL.getMessage());
        }
        return  Response.success("删除成功！");
    }


}

