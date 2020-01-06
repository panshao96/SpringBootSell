package com.imooc.sell.service;

import com.imooc.sell.dataobject.SellerInfo;

public interface SellerService {

    /**
     * 通过openid查询卖家账户信息
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);
}
