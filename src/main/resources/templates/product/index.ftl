<html>

<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--        边栏sidebar-->
    <#include "../common/nav.ftl">
    <#--        主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <form role="form" method="post" action="/sell/seller/product/save">
                        <div class="form-group">
                            <label>名称</label>
                            <input name="infoName" type="text" class="form-control" value="${(productInfo.infoName)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>价格</label>
                            <input name="infoPrice" type="text" class="form-control" value="${(productInfo.infoPrice)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>库存</label>
                            <input name="infoStock" type="number" class="form-control" value="${(productInfo.infoStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="infoDescription" type="text" class="form-control" value="${(productInfo.infoDescription)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>图片</label>
                            <img height="100" width="100" src="${(productInfo.infoIcon)!''}" alt="">
                            <input name="infoIcon" type="text" class="form-control" value="${(productInfo.infoIcon)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>类目</label>
                            <select name="categoryType" class="form-control">
                                <#list categoryList as category>
                                    <option value="${category.categoryType}"
                                            <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                                selected
                                            </#if>
                                    >${category.categoryName}
                                    </option>
                                </#list>
                            </select>
                        </div>
                        <input hidden type="text" name="infoId" value="${(productInfo.infoId)!''}">
                        <button type="submit" class="btn btn-default">提交</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>




