package com.color.dao;


import com.color.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    /**
     * 查询所有的书籍并返回
     * @return
     * @throws Exception
     */
    List<Product> queryAllProduct() throws Exception;

    /**
     * 添加产品
     * @param product
     */
    void addProduct(Product product);

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
    Product queryProductById(@Param("id") int id);
}
