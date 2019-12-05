package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author panshao
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 传入订单id，返回该订单下的所有商品
     * @param orderId 订单的id
     * @return 对应订单的所有商品
     */
    List<OrderDetail> findByOrderId(String orderId);
}
