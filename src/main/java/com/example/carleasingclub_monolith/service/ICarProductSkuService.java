package com.example.carleasingclub_monolith.service;

import com.example.carleasingclub_monolith.entity.CarProductSku;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
public interface ICarProductSkuService extends IService<CarProductSku> {

    /***
     * @Description 添加汽车商品规格
     * @author chennanjiang
     * @date 2022/5/9 19:57
     * @params [carProductSku]
     * @return int
     */
    int addPorductSku(CarProductSku carProductSku);
}
