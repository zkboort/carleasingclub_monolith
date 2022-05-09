package com.example.carleasingclub_monolith.service;

import com.example.carleasingclub_monolith.entity.CarProductBrand;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
public interface ICarProductBrandService extends IService<CarProductBrand> {

    /***
     * @Description 添加单个商品品牌
     * @author chennanjiang
     * @date 2022/5/9 19:20
     * @params [carProductBrand]
     * @return int
     */
    int addCarProductBrand(CarProductBrand carProductBrand);

    /***
     * @Description 根据品牌Id查询品牌信息
     * @author chennanjiang
     * @date 2022/5/9 19:32
     * @params [id]
     * @return com.example.carleasingclub_monolith.entity.CarProductBrand
     */
    CarProductBrand getCarProductBrandById(Integer id);

    /***
     * @Description 根据品牌的id修改品牌信息
     * @author chennanjiang
     * @date 2022/5/9 19:40
     * @params [carProductBrand]
     * @return int
     */
    int updateBrandInfo(CarProductBrand carProductBrand);

    /***
     * @Description 根据品牌Id删除品牌信息
     * @author chennanjiang
     * @date 2022/5/9 19:49
     * @params [id]
     * @return int
     */
    int deleteBrandById(Integer id);
}
