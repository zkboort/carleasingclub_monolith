package com.example.carleasingclub_monolith.controller;


import com.example.carleasingclub_monolith.common.result.Response;
import com.example.carleasingclub_monolith.common.utils.StatusCodeEnue;
import com.example.carleasingclub_monolith.entity.CarProductSku;
import com.example.carleasingclub_monolith.entity.CarProductSpu;
import com.example.carleasingclub_monolith.service.impl.CarProductSkuServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/carProductSku")
@Api("商品规格表管理")
public class CarProductSkuController {
    @Autowired
    private CarProductSkuServiceImpl carProductSkuServiceIpml;

    @ApiOperation("添加汽车商品规格")
    @PostMapping("/addProductSku")
    public Response  addCarProductSku(CarProductSku carProductSku){
        int number=carProductSkuServiceIpml.addPorductSku(carProductSku);
        if(number==0){
            return Response.error(StatusCodeEnue.ADD_FAIL.getCode(), StatusCodeEnue.ADD_FAIL.getMessage());
        }
        return  Response.success("添加成功！");
    }
}

