package com.example.carleasingclub_monolith.service;

import com.example.carleasingclub_monolith.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zkboort
 * @since 2022-04-29
 */
public interface IRoleService extends IService<Role> {
    /***
     * @Description 添加用户角色和权限
     * @author chennanjiang
     * @date 2022/5/9 11:04
     * @params [role]
     * @return int
     */
    int addRole(Role role);

    /***
     * @Description 获取所有角色和权限信息
     * @author chennanjiang
     * @date 2022/5/9 11:25
     * @params []
     * @return java.util.List<com.example.carleasingclub_monolith.entity.Role>
     */
    List<Role> getAllRoles();

    /***
     * @Description 根据角色ID修改角色权限信息
     * @author chennanjiang
     * @date 2022/5/9 11:42
     * @params [id]
     * @return int
     */
    int updateRole(Role role);

    /***
     * @Description 根据角色id删除角色权限信息
     * @author chennanjiang
     * @date 2022/5/9 11:42
     * @params []
     * @return int
     */
    int deleteRoleById(Integer id);
}
