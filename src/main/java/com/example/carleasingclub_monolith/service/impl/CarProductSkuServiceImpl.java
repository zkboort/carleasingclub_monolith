package com.example.carleasingclub_monolith.service.impl;

import com.example.carleasingclub_monolith.entity.CarProductSku;
import com.example.carleasingclub_monolith.mapper.CarProductSkuMapper;
import com.example.carleasingclub_monolith.service.ICarProductSkuService;
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
public class CarProductSkuServiceImpl extends ServiceImpl<CarProductSkuMapper, CarProductSku> implements ICarProductSkuService {
    @Autowired
    private CarProductSkuMapper carProductSkuMapper;

    /***
     * @Description 添加汽车商品规格
     * @author chennanjiang
     * @date 2022/5/9 20:11
     * @params [carProductSku]
     * @return int
     */
    @Override
    public int addPorductSku(CarProductSku carProductSku) {
        return carProductSkuMapper.insert(carProductSku);
    }


}
