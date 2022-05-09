package com.example.carleasingclub_monolith.controller;


import com.example.carleasingclub_monolith.common.result.Response;
import com.example.carleasingclub_monolith.common.utils.StatusCodeEnue;
import com.example.carleasingclub_monolith.entity.CarProductSpu;
import com.example.carleasingclub_monolith.service.impl.CarProductSpuServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/carProduct")
@Api("商品表spu信息管理")
public class CarProductSpuController {
     @Autowired
     private CarProductSpuServiceImpl carProductSpuServiceIpml;

     @ApiOperation("添加商品")
     @PostMapping("/addProduct")
     public Response addProduct(CarProductSpu carProductSpu){
         int number=carProductSpuServiceIpml.addProduct(carProductSpu);
         if(number==0){
             return Response.error(StatusCodeEnue.ADD_FAIL.getCode(), StatusCodeEnue.ADD_FAIL.getMessage());
         }
         return Response.success("添加成功！");
     }

     @ApiOperation("根据商品id查询商品")
     @GetMapping("/getProductById")
     public Response queryProductById(Integer productId){
         CarProductSpu carProductSpu=carProductSpuServiceIpml.getCarProductById(productId);
         if(carProductSpu==null){
             return Response.error(StatusCodeEnue.QUERY_FAIL.getCode(),StatusCodeEnue.QUERY_FAIL.getMessage());
         }
         return  Response.success("查询成功！",carProductSpu);
     }

     @ApiOperation("根据商品Id修改商品信息")
     @PostMapping("/updateProductInfo")
     public Response updateProductInfo(CarProductSpu carProductSpu){
         int number=carProductSpuServiceIpml.updateProductInfo(carProductSpu);
         if(number==0){
             return Response.error(StatusCodeEnue.UPDATE_FAIL.getCode(),StatusCodeEnue.UPDATE_FAIL.getMessage());
         }
         return Response.success("修改成功！");
     }

     @ApiOperation("根据商品ID删除单个商品")
     @PostMapping("/deleteProductById")
     public Response deleteproductById(Integer id){
         int number=carProductSpuServiceIpml.deleteProductById(id);
         if(number==0){
             return Response.error(StatusCodeEnue.DELETE_FAIL.getCode(), StatusCodeEnue.DELETE_FAIL.getMessage());
         }
         return Response.success("删除成功！");

     }
}

