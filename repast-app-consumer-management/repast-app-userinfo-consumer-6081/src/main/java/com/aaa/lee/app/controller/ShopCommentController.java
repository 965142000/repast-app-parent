package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.domain.Comment;
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
 * @日期：2019-11-22 9:11
 */
@RestController
@Api(value = "店铺评价" , tags = "根据店铺id查询店铺评价")
public class ShopCommentController extends BaseController {

    @Autowired
    private IRepastService repastService;

    /**
     * 通过商家店铺id查询店铺评价
     * @param shopId
     * @return
     */
    @GetMapping("/getShopCommentById")
    @ApiOperation(value = "查询店铺评价" , notes = "通过主键查询商家全部评价" )
    public ResultData getShopCommentById(Long shopId){
        List<Comment> shopCommentById = repastService.getShopCommentById(shopId);
        if (null != shopCommentById){
            return success(shopCommentById);
        }else {
            return failed();
        }
    }
}
