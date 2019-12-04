package com.imooc.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author panshao
 */
@AllArgsConstructor
@Getter
public enum InfoStatusEnum {

    UP(0, "上架"),
    DOWN(1, "下架"),
    ;


    private Integer code;

    private String msg;

}
