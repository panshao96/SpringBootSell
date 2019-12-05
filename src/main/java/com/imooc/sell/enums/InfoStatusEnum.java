package com.imooc.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品的状态
 * @author panshao
 */
@AllArgsConstructor
@Getter
public enum InfoStatusEnum {

    /**
     * 上架状态
     */
    UP(0, "上架"),
    /**
     * 下架状态
     */
    DOWN(1, "下架")
    ;

    private Integer code;

    private String msg;

}
