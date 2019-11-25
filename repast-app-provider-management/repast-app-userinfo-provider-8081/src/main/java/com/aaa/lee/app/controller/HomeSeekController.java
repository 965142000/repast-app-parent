package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.HomeSeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @作者：吴文博
 * @项目：repast-app-parent
 * @包：com.aaa.lee.app.controller
 * @日期：2019-11-22 20:25
 */
@RestController
public class HomeSeekController {

    @Autowired
    private HomeSeekService homeSeekService;

    /**
     * 根据商品name或keywords或product_category_name进行对全部商品的模糊搜索
     * @param keywords
     * @return
     */
    @GetMapping("/homeSeekProduct")
    public List<Product> homeSeekProduct(@RequestParam("keywords") String keywords){
        List<Product> products = homeSeekService.HomeSeekProduct(keywords);
        return products;
    };

}
