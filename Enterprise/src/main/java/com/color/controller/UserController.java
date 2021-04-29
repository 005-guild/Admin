package com.color.controller;

import com.github.pagehelper.PageInfo;
import com.color.entity.Role;
import com.color.entity.UserInfo;
import com.color.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author color
 * @version 1.0
 * @date 2021/4/15 15:21
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 查询所有的用户
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/queryAllUser.do")
    public ModelAndView queryAllUser(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "10") Integer size){
        ModelAndView mv = new ModelAndView();
        List<User> users = userService.queryAllUser(page,size);
        PageInfo pageInfo = new PageInfo(users);
        mv.addObject("userList",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    @RequestMapping("/addUser.do")
    public String addUser(UserInfo userInfo){
        userService.addUser(userInfo);
        return "redirect:queryAllUser.do";
    }

    /**
     * 通过Id查询用户
     * @param id
     * @return
     */
    @RequestMapping("/queryUserById.do")
    public ModelAndView queryUserById(Integer id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.queryUserById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /**
     * 查询出用户及用户没有的角色信息
     * @param id
     * @return
     */
    @RequestMapping("/queryUserByIdAndAllRole.do")
    public ModelAndView queryUserByIdAndAllRole(Integer id){
        ModelAndView mv = new ModelAndView();
        // 先查询出用户的信息
        UserInfo userInfo = userService.queryUserById(id);
        // 再查询出用户没有的角色信息
        List<Role> roles = userService.queryOtherRoles(id);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",roles);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) Integer userId,@RequestParam(name = "ids",required = true) int[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:queryAllUser.do";
    }
}
