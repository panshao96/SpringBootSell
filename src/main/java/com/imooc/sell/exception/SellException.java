package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

/**
 * @author panshao
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
