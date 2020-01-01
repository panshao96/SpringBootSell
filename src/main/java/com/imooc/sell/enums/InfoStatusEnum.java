package com.imooc.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 商品的状态
 * @author panshao
 */
@AllArgsConstructor
@Getter
public enum InfoStatusEnum implements CodeEnum{

    /** */
    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;

    private String msg;

}
