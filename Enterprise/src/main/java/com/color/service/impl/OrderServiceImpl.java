package com.color.service.impl;

import com.color.dao.OrderDao;
import com.color.entity.Orders;
import com.color.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author color
 * @version 1.0
 * @date 2021/4/08 12:23
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Orders> queryAllOrders(int page, int size) {
        PageHelper.startPage(page,size);
        return orderDao.queryAllOrders();
    }

    @Override
    public Orders queryOrderById(int id) {
        return orderDao.queryOrderById(id);
    }
}
