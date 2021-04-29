package com.color.service;

import com.color.entity.Permission;
import com.color.entity.Role;

import java.util.List;

public interface RoleService {
    /**
     * 查询全部角色
     * @param page
     * @param size
     * @return
     */
    List<Role> queryAllRole(int page,int size);

    /**
     * 添加角色
     * @param role
     */
    void addRole(Role role);

    /**
     * 根据ID查询角色
     * @param id
     * @return
     */
    Role queryRoleById(int id);

    /**
     * 查询出角色可以添加的权限
     * @param id
     * @return
     */
    List<Permission> queryOtherPermissions(int id);

    /**
     * 给角色添加权限
     * @param roleId
     * @param ids
     */
    void addPermissionToRole(int roleId, int[] ids);
}
