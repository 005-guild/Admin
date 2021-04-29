package com.color.controller;

import com.github.pagehelper.PageInfo;
import com.color.entity.Product;
import com.color.service.ProductSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author color
 * @version 1.0
 * @date 2021/4/11 12:21
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductSerice productService;

    /**
     * 查询全部产品
     * @return
     * @throws Exception
     */
    @RequestMapping("/queryAllProduct.do")
    public ModelAndView queryAllProduct(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page, @RequestParam(name = "size",required = true,defaultValue = "10") Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.queryAllProduct(page,size);
        PageInfo pageInfo = new PageInfo(products);
        mv.addObject("productList", pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    /**
     * 添加产品
     * @param product
     * @return
     * @throws Exception
     */
    @RequestMapping("/AddProduct.do")
    public String addProduct(Product product) throws Exception {
        // 判断是是新增还是编辑
        if(product.getId()!=null&& product.getId()>0){
            productService.updateProduct(product);
        }else{
            productService.addProduct(product);
        }
        return "redirect:queryAllProduct.do";
    }

    /**
     * 打开编辑页面
     * @param id
     * @return
     */
    @RequestMapping("/toUpdateProductPaper.do")
    public ModelAndView toUpdateProductPaper(Integer id){
        ModelAndView mv = new ModelAndView();
        Product product = productService.queryProductById(id);
        mv.addObject("product",product);
        mv.setViewName("product-add");
        return mv;
    }
}
