package com.aaa.lee.app.controller;

import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.service.ShopCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @作者：吴文博
 * @项目：repast-app-parent
 * @包：com.aaa.lee.app.controller
 * @日期：2019-11-22 9:15
 */
@RestController
public class ShopCommentController {

    @Autowired
    private ShopCommentService shopCommentService;

    /**
     * 通过店铺id查询出店铺评价
     * @param shopId
     * @return
     */
    @GetMapping("/getShopCommentById")
    public List<Comment> getShopCommentById(@RequestParam("shopId") Long shopId){
        Comment comment = new Comment().setShopId(shopId);
        try {
            List<Comment> comments = shopCommentService.selectDomain(comment);
            if (comments.size() > 0){
                return comments;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    };

}
