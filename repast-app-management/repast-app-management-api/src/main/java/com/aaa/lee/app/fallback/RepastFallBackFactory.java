package com.aaa.lee.app.fallback;

import com.aaa.lee.app.domain.Comment;
import com.aaa.lee.app.domain.Product;
import com.aaa.lee.app.service.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/11/20 11:41
 * @Description
 **/
@Component
public class RepastFallBackFactory implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService() {

            @Override
            public List<Comment> getShopCommentById(Long shopId) {
                System.out.println("根剧店铺id获取店铺评价的容错信息");
                return null;
            }

            @Override
            public List<Product> homeSeekProduct(String keywords) {
                System.out.println("首页搜索的容错信息");
                return null;
            }
        };
        return repastService;
    }
}
