package com.example.carleasingclub_monolith.service.impl;

import com.example.carleasingclub_monolith.entity.CarProductSpu;
import com.example.carleasingclub_monolith.mapper.CarProductSpuMapper;
import com.example.carleasingclub_monolith.service.ICarProductSpuService;
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
public class CarProductSpuServiceImpl extends ServiceImpl<CarProductSpuMapper, CarProductSpu> implements ICarProductSpuService {
    @Autowired
    private CarProductSpuMapper carProductSpuMapper;

    /***
     * @Description 添加商品
     * @author chennanjiang
     * @date 2022/5/9 16:18
     * @params [carProductSpu]
     * @return int
     */
    @Override
    public int addProduct(CarProductSpu carProductSpu) {
        return carProductSpuMapper.insert(carProductSpu);
    }

    /**
     * @Description 根据商品ID查询商品信息
     * @author chennanjiang
     * @date 2022/5/9 18:43
     * @params [id]
     * @return com.example.carleasingclub_monolith.entity.CarProductSpu
     */
    @Override
    public CarProductSpu getCarProductById(Integer id) {
        return carProductSpuMapper.selectById(id);
    }

    /***
     * @Description 根据商品Id修改商品信息
     * @author chennanjiang
     * @date 2022/5/9 19:00
     * @params [carProductSpu]
     * @return int
     */
    @Override
    public int updateProductInfo(CarProductSpu carProductSpu) {
        return carProductSpuMapper.updateById(carProductSpu);
    }

    /***
     * @Description 根据商品ID删除单个商品
     * @author chennanjiang
     * @date 2022/5/9 19:00
     * @params [id]
     * @return int
     */
    @Override
    public int deleteProductById(Integer id) {
        return 0;
    }
}
