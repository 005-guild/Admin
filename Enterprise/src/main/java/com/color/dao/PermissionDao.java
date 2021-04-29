package com.color.dao;

import com.color.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {
    /**
     * 查询全部资源
     * @return
     */
    List<Permission> queryAllPermission();

    /**
     * 添加权限资源
     * @param permission
     */
    void addPermission(Permission permission);

    /**
     * 根据权限资源ID查询资源
     * @param id
     * @return
     */
    Permission queryPermissionById(@Param("id") int id);
}
