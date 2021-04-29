package com.color.dao;

import com.color.entity.Orders;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    /**
     * 查询所有的订单
     * @return
     */
    List<Orders> queryAllOrders();

    /**
     * 根据ID查询订单
     * @param id
     * @return
     */
    Orders queryOrderById(@Param("id") int id);
}
