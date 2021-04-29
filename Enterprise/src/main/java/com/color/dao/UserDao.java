package com.color.dao;


import com.color.entity.Role;
import com.color.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.userdetails.User;

import java.util.List;


public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    UserInfo queryUserByUsername(@Param("username") String username);

    /**
     * 查询所有的用户
     * @return
     */
    List<User> queryAllUser();

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
    UserInfo queryUserById(@Param("id") int id);

    /**
     * 查询出用户没有的角色信息
     * @param id
     * @return
     */
    List<Role> queryOtherRoles(@Param("id") int id);

    /**
     * 给用户添加角色
     * @param userId
     * @param roleId
     */
    void addRoleToUser(@Param("userId") int userId, @Param("roleId") int roleId);
}
