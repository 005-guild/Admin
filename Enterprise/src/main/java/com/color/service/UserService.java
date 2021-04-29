package com.color.service;

import com.color.entity.Role;
import com.color.entity.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author color
 * @Description 自定义的spring security服务接口并继承UserDetailsService，用于规范spring security接口
 * @date 2020/4/13
 */
public interface UserService extends UserDetailsService {

    /**
     * 查询所有的用户
     * @param page
     * @param size
     * @return
     */
    List<User> queryAllUser(int page,int size);

    /**
     * 添加用户
     * @param userInfo
     */
    void addUser(UserInfo userInfo);

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    UserInfo queryUserById(int id);

    /**
     * 通过ID查询出用户没有的角色
     * @param id
     * @return
     */
    List<Role> queryOtherRoles(int id);

    /**
     * 给用户批量添加角色
     * @param userId
     * @param roleIds
     */
    void addRoleToUser(int userId, int[] roleIds);
}
