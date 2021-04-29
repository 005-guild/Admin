package com.color.service;

import com.color.entity.Orders;

import java.util.List;

/**
 * @author color
 * @version 1.0
 * @date 2021/4/08 12:22
 */
public interface OrderService {
    /**
     * 查询所有的订单
     * @param page
     * @param size
     * @return
     */
    List<Orders> queryAllOrders(int page, int size);

    /**
     * 根据ID查询订单
     * @param id
     * @return
     */
    Orders queryOrderById(int id);
}

