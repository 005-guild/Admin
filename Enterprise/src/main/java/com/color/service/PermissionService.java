package com.color.service;

import com.color.entity.Permission;

import java.util.List;

public interface PermissionService {
    /**
     * 查询全部资源
     * @return
     */
    List<Permission> queryAllPermission(int page,int size);

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
    Permission queryPermissionById(int id);
}
