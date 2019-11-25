package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.IRepastService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @作者：吴文博
 * @项目：repast-app-parent
 * @包：com.aaa.lee.app.controller
 * @日期：2019-11-22 20:07
 */
@RestController
@Api(value = "首页搜索框" , tags = "首页搜索框搜索商品")
public class HomeSeekController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 根据商品name或keywords或product_category_name进行对全部商品的模糊搜索
     * @param keywords
     * @return
     */
    @GetMapping("/homeSeekProduct")
    @ApiOperation(value = "首页搜索" , notes = "首页搜索商品列表")
    public ResultData homeSeekProduct(String keywords){
        List<Product> products = repastService.homeSeekProduct(keywords);
        if (products.size() > 0){
            return success(products);
        }else{
            return failed();
        }
    }

}
