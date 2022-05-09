package com.example.carleasingclub_monolith.controller;


import com.example.carleasingclub_monolith.common.result.Response;
import com.example.carleasingclub_monolith.common.utils.StatusCodeEnue;
import com.example.carleasingclub_monolith.entity.CarProductBrand;
import com.example.carleasingclub_monolith.service.impl.CarProductBrandServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
@RestController
@RequestMapping("/carleasingclub_monolith/carProductBrand")
public class CarProductBrandController {
    @Autowired
    private CarProductBrandServiceImpl carProductBrandServiceImpl;

    @ApiOperation("添加单个汽车商品品牌")
    @PostMapping("/addCarProductBrand")
    public Response addCarProductBrand(CarProductBrand carProductBrand){
        int number=carProductBrandServiceImpl.addCarProductBrand(carProductBrand);
        if(number==0){
            return Response.error(StatusCodeEnue.ADD_FAIL.getCode(), StatusCodeEnue.ADD_FAIL.getMessage());
        }
        return Response.success("添加成功！");
    }

    @ApiOperation("根据品牌Id查询品牌信息")
    @GetMapping("/getCarProductBrand")
    public  Response queryCarProductBrandById(Integer id){
        CarProductBrand carProductBrand=carProductBrandServiceImpl.getCarProductBrandById(id);
        if(carProductBrand==null){
            return Response.error(StatusCodeEnue.QUERY_FAIL.getCode(), StatusCodeEnue.QUERY_FAIL.getMessage());
        }
        return Response.success("查询成功！",carProductBrand);
    }

    @ApiOperation("根据品牌的id修改品牌信息")
    @PostMapping("/updateCarProductBrandInfo")
    public Response updateCarProductBrandInfo(CarProductBrand carProductBrand){
        int number=carProductBrandServiceImpl.updateBrandInfo(carProductBrand);
        if(number==0){
            return Response.error(StatusCodeEnue.UPDATE_FAIL.getCode(), StatusCodeEnue.UPDATE_FAIL.getMessage());
        }
        return Response.success("修改成功！");

    }
    @ApiOperation("根据品牌Id删除品牌信息")
    @DeleteMapping("/deleteBrandById")
    public Response deleteBrandById(Integer id){
       int number=carProductBrandServiceImpl.deleteBrandById(id);
        if(number==0){
            return Response.error(StatusCodeEnue.DELETE_FAIL.getCode(), StatusCodeEnue.DELETE_FAIL.getMessage());
        }
        return Response.success("删除成功！");
    }
}

