package com.imooc.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 订单状态
 * @author panshao
 */
@Getter
@AllArgsConstructor
public enum OrderStatusEnum {

    /**
     * 新的订单
     */
    NEW(0, "新订单"),

    /**
     * 完成的订单
     */
    FINISHED(1, "已完结"),

    /**
     * 取消的订单
     */
    CANCEL(2, "已取消");

    private Integer code;

    private String msg;
}
