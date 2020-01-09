package com.imooc.sell.service;

public interface SecKillService {

    //返回当前信息
    String querySecKillProductInfo(String productId);

    //模拟用户下单
    void orderProductMockDiffUser(String productId);
}
