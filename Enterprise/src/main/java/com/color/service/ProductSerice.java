package com.color.service;


import com.color.entity.Product;

import java.util.List;

/**
 * @author color
 */
public interface ProductSerice {

    /**
     * 查询所有的书籍并返回
     * @param page
     * @param size
     * @return
     * @throws Exception
     */
    List<Product> queryAllProduct(int page,int size) throws Exception;

    /**
     * 添加产品
     * @param product
     * @throws Exception
     */
    void addProduct(Product product) throws Exception;


    /**
     * 更新产品
     * @param product
     * @return
     */
    int updateProduct(Product product);

    /**
     * 根据产品ID查询产品
     * @param id
     * @return
     */
    Product queryProductById(int id);
}
