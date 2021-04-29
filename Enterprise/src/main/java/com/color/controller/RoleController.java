package com.color.controller;

import com.github.pagehelper.PageInfo;
import com.color.entity.Permission;
import com.color.entity.Role;
import com.color.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询全部角色
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/queryAllRole.do")
    public ModelAndView queryAllRole(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "10") Integer size){
        ModelAndView mv = new ModelAndView();
        List<Role> roles = roleService.queryAllRole(page, size);
        PageInfo pageInfo = new PageInfo(roles);
        mv.addObject("roleList",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @RequestMapping("/addRole.do")
    public String addRole(Role role){
        roleService.addRole(role);
        return "redirect:queryAllRole.do";
    }

    /**
     * 根据ID查询角色
     * @param id
     * @return
     */
    @RequestMapping("/queryRoleById.do")
    public ModelAndView queryRoleById(Integer id){
        ModelAndView mv = new ModelAndView();
        Role role = roleService.queryRoleById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    /**
     * 查询角色并查询可以添加的权限信息
     * @param id
     * @return
     */
    @RequestMapping("/queryRoleByIdAndAllPermission.do")
    public ModelAndView queryRoleByIdAndAllPermission(Integer id){
        ModelAndView mv = new ModelAndView();
        // 查询出角色
        Role role = roleService.queryRoleById(id);
        List<Permission> permissions = roleService.queryOtherPermissions(id);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissions);
        mv.setViewName("role-permission-add");
        // 查询出角色可以添加的权限
        return mv;
    }

    /**
     * 为角色添加权限
     * @param roleId
     * @param ids
     * @return
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true)Integer roleId,@RequestParam(name = "ids",required = true) int[] ids){
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:queryAllRole.do";
    }
}
