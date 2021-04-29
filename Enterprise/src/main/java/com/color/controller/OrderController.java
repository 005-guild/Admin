package com.color.controller;

import com.color.entity.Orders;
import com.color.service.OrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author color
 * @version 1.0
 * @date 2021/4/10 12:21
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/queryAllOrders.do")
    public ModelAndView queryAllOrders(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "size",required = true,defaultValue = "10") Integer size){
        ModelAndView mv = new ModelAndView();
        List<Orders> orders = orderService.queryAllOrders(page,size);
        PageInfo pageInfo = new PageInfo(orders);
        mv.addObject("ordersList",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/queryOrderById.do")
    public ModelAndView queryOrderById(@RequestParam(name = "id",required = true) Integer id){
        ModelAndView mv = new ModelAndView();
        Orders orders = orderService.queryOrderById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
