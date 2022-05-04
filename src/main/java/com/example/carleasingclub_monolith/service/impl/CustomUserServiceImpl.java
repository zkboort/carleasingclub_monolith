package com.example.carleasingclub_monolith.service.impl;

import com.example.carleasingclub_monolith.entity.CustomUser;
import com.example.carleasingclub_monolith.mapper.CustomUserMapper;
import com.example.carleasingclub_monolith.service.ICustomUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CustomUserServiceImpl extends ServiceImpl<CustomUserMapper, CustomUser> implements ICustomUserService {

}
