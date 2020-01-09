package com.imooc.sell.service.impl;

import com.imooc.sell.exception.SellException;
import com.imooc.sell.service.RedisLock;
import com.imooc.sell.service.SecKillService;
import com.imooc.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class SecKillServiceImpl implements SecKillService {

    private static final int TIMEOUT = 10 * 1000; //超时时间5s

    @Autowired
    private RedisLock redisLock;


    static Map<String, Integer> products;
    static Map<String, Integer> stock;
    static Map<String, String> orders;
    static {
        /**
         * 模拟多个表
         */
        //商品信息表
        products = new HashMap<>();
        //库存表
        stock = new HashMap<>();
        //秒杀成功的订单表
        orders = new HashMap<>();
        //100000份"123456"
        products.put("123456", 100000);
        stock.put("123456", 100000);
    }

    private String queryMap(String productId) {
        return "限量：" + products.get(productId)
                + " 还剩：" + stock.get(productId) + " 份"
                + " 成功下单：" + orders.size() + " 人";
    }

    @Override
    public String querySecKillProductInfo(String productId) {
        return this.queryMap(productId);
    }

    @Override
    public void orderProductMockDiffUser(String productId) {
        //目的是下单部分代码只能单线程访问
        //1、加锁
        //2、解锁

        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if (redisLock.lock(productId, String.valueOf(time))) {
            throw new SellException(101, "排队失败，请重试！");
        }

        //1、查询该商品库存，为0则活动结束
        int stockNum = stock.get(productId);
        if (stockNum == 0) {
            throw new SellException(100, "活动结束");
        }else {
            //2、下单,用keyUtil模拟不同用户的openid
            orders.put(KeyUtil.genUniqueKey(), productId);
            //3、减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }
}
