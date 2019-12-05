package com.imooc.sell.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 支付状态
 * @author panshao
 */
@Getter
@AllArgsConstructor
public enum PayStatusEnum {

    /** */
    WAIT(0, "等待支付"),
    SUCCESS(1, "完成支付");

    private Integer code;

    private String msg;
}
