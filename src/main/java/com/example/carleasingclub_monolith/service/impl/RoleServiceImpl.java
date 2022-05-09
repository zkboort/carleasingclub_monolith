package com.example.carleasingclub_monolith.service.impl;

import com.example.carleasingclub_monolith.entity.Role;
import com.example.carleasingclub_monolith.mapper.RoleMapper;
import com.example.carleasingclub_monolith.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Autowired
    private RoleMapper roleMapper;

    /***
     * @Description
     * @author chennanjiang
     * @date 2022/5/9 11:09
     * @params [role]
     * @return int
     */
    @Override
    public int addRole(Role role) {
        return roleMapper.insert(role);
    }

    /***
     * @Description 获取所有角色和权限信息
     * @author chennanjiang
     * @date 2022/5/9 11:27
     * @params []
     * @return java.util.List<com.example.carleasingclub_monolith.entity.Role>
     */
    @Override
    public List<Role> getAllRoles() {
       return roleMapper.selectList(null);
    }


    /***
     * @Description 根据角色ID修改角色权限信息
     * @author chennanjiang
     * @date 2022/5/9 11:44
     * @params [id]
     * @return int
     */
    @Override
    public int updateRole(Role role) {
        return roleMapper.updateById(role);
    }


    /***
     * @Description 根据角色id删除角色权限信息
     * @author chennanjiang
     * @date 2022/5/9 11:44
     * @params []
     * @return int
     */
    @Override
    public int deleteRoleById(Integer id) {
        return roleMapper.deleteById(id);
    }
}
