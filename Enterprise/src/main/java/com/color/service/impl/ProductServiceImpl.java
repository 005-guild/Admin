package com.color.service.impl;

import com.github.pagehelper.PageHelper;
import com.color.dao.ProductDao;
import com.color.entity.Product;
import com.color.service.ProductSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductSerice {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> queryAllProduct(int page,int size) throws Exception {
        PageHelper.startPage(page,size);
        return productDao.queryAllProduct();
    }

    @Override
    public void addProduct(Product product) throws Exception {
        productDao.addProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return productDao.updateProduct(product);
    }

    @Override
    public Product queryProductById(int id) {
        return productDao.queryProductById(id);
    }
}
