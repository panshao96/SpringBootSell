package com.imooc.sell.dto;

import com.imooc.sell.dataobject.OrderDetail;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author panshao
 */
@Data
@NoArgsConstructor
public class OrderDTO {

    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 订单内全部商品详情 */
    private List<OrderDetail> orderDetailList;

    /** 创建时间. */
    @CreatedDate
    private Date createTime;

    /** 更新时间. */
    @LastModifiedDate
    private Date updateTime;
}
