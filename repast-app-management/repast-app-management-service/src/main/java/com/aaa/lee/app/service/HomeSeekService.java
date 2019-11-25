package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @作者：吴文博
 * @项目：repast-app-parent
 * @包：com.aaa.lee.app.service
 * @日期：2019-11-22 20:28
 */
@Service
public class HomeSeekService extends BaseService<Product> {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Mapper<Product> getMapper() {
        return productMapper;
    }

    /**
     * 根据商品name或keywords或product_category_name进行对全部商品的模糊搜索
     * @param keywords
     * @return
     */
    public List<Product> HomeSeekProduct(String keywords){
        return productMapper.HomeSeekProduct(keywords);
    }
}
