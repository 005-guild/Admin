package com.color.service.impl;

import com.github.pagehelper.PageHelper;
import com.color.dao.RoleDao;
import com.color.entity.Permission;
import com.color.entity.Role;
import com.color.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> queryAllRole(int page, int size) {
        PageHelper.startPage(page,size);
        return roleDao.queryAllRole();
    }

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public Role queryRoleById(int id) {
        return roleDao.queryRoleById(id);
    }

    @Override
    public List<Permission> queryOtherPermissions(int id) {
        return roleDao.queryOtherPermissions(id);
    }

    @Override
    public void addPermissionToRole(int roleId, int[] ids) {
        for (int id : ids) {
            roleDao.addPermissionToRole(roleId,id);
        }
    }


}
