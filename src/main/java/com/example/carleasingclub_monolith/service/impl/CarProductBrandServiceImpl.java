package com.example.carleasingclub_monolith.service.impl;

import com.example.carleasingclub_monolith.entity.CarProductBrand;
import com.example.carleasingclub_monolith.mapper.CarProductBrandMapper;
import com.example.carleasingclub_monolith.service.ICarProductBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
@Service
public class CarProductBrandServiceImpl extends ServiceImpl<CarProductBrandMapper, CarProductBrand> implements ICarProductBrandService {
    @Autowired
    private CarProductBrandMapper carProductBrandMapper;

    /***
     * @Description 添加单个商品品牌
     * @author chennanjiang
     * @date 2022/5/9 19:20
     * @params [carProductBrand]
     * @return int
     */
    @Override
    public int addCarProductBrand(CarProductBrand carProductBrand) {
        return carProductBrandMapper.insert(carProductBrand);
    }

    /***
     * @Description 根据品牌Id查询品牌信息
     * @author chennanjiang
     * @date 2022/5/9 19:32
     * @params [id]
     * @return com.example.carleasingclub_monolith.entity.CarProductBrand
     */
    @Override
    public CarProductBrand getCarProductBrandById(Integer id) {
        return carProductBrandMapper.selectById(id);
    }

    /***
     * @Description 根据品牌的id修改品牌信息
     * @author chennanjiang
     * @date 2022/5/9 19:41
     * @params [carProductBrand]
     * @return int
     */
    @Override
    public int updateBrandInfo(CarProductBrand carProductBrand) {
        return carProductBrandMapper.updateById(carProductBrand);
    }

    /***
     * @Description 根据品牌Id删除品牌信息
     * @author chennanjiang
     * @date 2022/5/9 19:50
     * @params [id]
     * @return int
     */
    @Override
    public int deleteBrandById(Integer id) {
        return carProductBrandMapper.deleteById(id);
    }
}
