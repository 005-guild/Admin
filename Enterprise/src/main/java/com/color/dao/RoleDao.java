package com.color.dao;


import com.color.entity.Permission;
import com.color.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RoleDao {
    /**
     * 查询全部角色
     * @return
     */
    List<Role> queryAllRole();

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
    Role queryRoleById(@Param("id") int id);

    /**
     * 查询出角色可以添加的权限
     * @param id
     * @return
     */
    List<Permission> queryOtherPermissions(int id);

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionId
     */
    void addPermissionToRole(@Param("roleId") int roleId,@Param("permissionId") int permissionId);
}
