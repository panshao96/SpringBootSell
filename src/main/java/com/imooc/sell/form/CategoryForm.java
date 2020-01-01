package com.imooc.sell.form;

import lombok.Data;

@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /**
     * 类目编号
     * 值唯一，若数据库中存在。那么就会报错
     * */
    private Integer categoryType;
}
