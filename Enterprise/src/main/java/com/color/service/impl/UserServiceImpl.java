package com.color.service.impl;

import com.github.pagehelper.PageHelper;
import com.color.dao.UserDao;
import com.color.entity.Role;
import com.color.entity.UserInfo;
import com.color.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author color
 * @Description 自定义 UserService的实现类
 * @date 2021/4/13
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 登录权限认证的service，我们这里没有写Controller，因为spring security帮我们写了
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.queryUserByUsername(username);
        System.out.println(userInfo);
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0?false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    /**
     * 获取当前登录用户的权限信息
     * @param roles
     * @return
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    /**
     * 查询所有的用户
     * @return
     */
    @Override
    public List<User> queryAllUser(int page,int size) {
        PageHelper.startPage(page,size);
        return userDao.queryAllUser();
    }

    /**
     * 添加用户
     * @param userInfo
     */
    @Override
    public void addUser(UserInfo userInfo) {
        // 使用 BCryptPasswordEncoder 对添加用户的密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.addUser(userInfo);
    }

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @Override
    public UserInfo queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    /**
     * 查询用户所没有的角色信息
     * @param id
     * @return
     */
    @Override
    public List<Role> queryOtherRoles(int id) {
        return userDao.queryOtherRoles(id);
    }

    @Override
    public void addRoleToUser(int userId, int[] roleIds) {
        for (int roleId : roleIds) {
            userDao.addRoleToUser(userId,roleId);
        }
    }

}
