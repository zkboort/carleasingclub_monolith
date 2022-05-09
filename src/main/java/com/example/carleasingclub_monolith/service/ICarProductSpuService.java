package com.example.carleasingclub_monolith.service;

import com.example.carleasingclub_monolith.entity.CarProductSpu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
public interface ICarProductSpuService extends IService<CarProductSpu> {

    /***
     * @Description 添加商品表单
     * @author chennanjiang
     * @date 2022/5/9 15:51
     * @params [carProductSpu]
     * @return int
     */
    int addProduct(CarProductSpu carProductSpu);

    /***
     * @Description 根据商品ID查询商品信息
     * @author chennanjiang
     * @date 2022/5/9 18:43
     * @params [id]
     * @return com.example.carleasingclub_monolith.entity.CarProductSpu
     */
    CarProductSpu getCarProductById(Integer id);

    /**
     * @Description 根据商品Id修改商品信息
     * @author chennanjiang
     * @date 2022/5/9 18:52
     * @params [carProductSpu]
     * @return int
     */
    int updateProductInfo(CarProductSpu carProductSpu);

    /***
     * @Description 根据商品ID删除单个商品
     * @author chennanjiang
     * @date 2022/5/9 18:59
     * @params [id]
     * @return int
     */
    int deleteProductById(Integer id);
}
