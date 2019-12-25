package com.imooc.sell.form;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author panshao
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家微信号
     */
    @NotEmpty(message = "微信号必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;

//    /** 创建时间. */
//    @CreatedDate
//    private Date createTime;
//
//    /** 更新时间. */
//    @LastModifiedDate
//    private Date updateTime;
}
