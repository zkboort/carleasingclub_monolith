package com.example.carleasingclub_monolith.controller;


import com.example.carleasingclub_monolith.common.result.Response;
import com.example.carleasingclub_monolith.service.impl.SystemUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class SystemUserController {
    @Autowired
    private SystemUserServiceImpl systemUserService;

    @RequestMapping("/addSystemUser")

    public Response addSystemUser(){
        return Response.success("");
    }

}

