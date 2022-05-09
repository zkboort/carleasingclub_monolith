package com.example.carleasingclub_monolith.controller;


import com.example.carleasingclub_monolith.common.result.Response;
import com.example.carleasingclub_monolith.common.utils.StatusCodeEnue;
import com.example.carleasingclub_monolith.entity.Role;
import com.example.carleasingclub_monolith.service.impl.RoleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/role")
@Api("角色权限管理")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleServiceImpl;

    @ApiOperation("添加角色权限")
    @PostMapping("/addRole")
    public Response addRole(Role role){
         int number=roleServiceImpl.addRole(role);
         if(number==0){
             return Response.error(StatusCodeEnue.ADD_FAIL.getCode(),StatusCodeEnue.LOGIN_FAIL.getMessage());
         }
         return Response.success("添加成功！");
    }
    @ApiOperation("查询所有角色权限")
    @GetMapping("/getAllRoles")
    public Response getAlRoles(){
        List<Role> allRoles=roleServiceImpl.getAllRoles();
        if(allRoles==null){
            return Response.error(StatusCodeEnue.QUERY_FAIL.getCode(), StatusCodeEnue.QUERY_FAIL.getMessage());
        }
        return Response.success("查询成功",allRoles);
    }

    @ApiOperation("根据角色权限Id修改角色权限")
    @PostMapping("/updateRoleById")
    public Response updateRoleById(Role role){
        int number=roleServiceImpl.updateRole(role);
        if(number==0){
            return Response.error(StatusCodeEnue.UPDATE_FAIL.getCode(),StatusCodeEnue.UPDATE_FAIL.getMessage());
        }
        return Response.success("修改成功！");
    }

    @ApiOperation("根据Id删除角色权限")
    @GetMapping("/deleteRoleById")
    public Response deleteRoleById(Integer id){
        int number=roleServiceImpl.deleteRoleById(id);
        if(number==0){
            return Response.error(StatusCodeEnue.DELETE_FAIL.getCode(), StatusCodeEnue.DELETE_FAIL.getMessage());
        }
        return Response.success("删除成功！");
    }
}

