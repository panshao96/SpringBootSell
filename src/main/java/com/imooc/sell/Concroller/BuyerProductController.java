package com.imooc.sell.Concroller;

import com.imooc.sell.Utils.ResultVOUtil;
import com.imooc.sell.VO.CategoryVO;
import com.imooc.sell.VO.InfoVO;
import com.imooc.sell.VO.ResultVO;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.InfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品
 * @author panshao
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list() {

        //1.查询所有的上架商品
        List<ProductInfo> productInfoList = infoService.findUpAll();

        //2.查询类目（一次性查询）

        //传统方法
//        List<Integer> categoryTypeList = new ArrayList<>();
//        for (ProductInfo productInfo : productInfoList) {
//            categoryTypeList.add(productInfo.getCategoryType());
//        }
        //精简方法(java8, lambda)
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装

        List<CategoryVO> categoryVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            CategoryVO categoryVO = new CategoryVO();
            categoryVO.setCategoryName(productCategory.getCategoryName());
            categoryVO.setCategoryType(productCategory.getCategoryType());

            List<InfoVO> infoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())) {
                    InfoVO infoVO = new InfoVO();
                    //将productInfo中的对应属性复制到infoVO,对应属性的命名要一致。不然不能复制
                    BeanUtils.copyProperties(productInfo, infoVO);
                    infoVOList.add(infoVO);
                }
            }
            categoryVO.setCategoryFoods(infoVOList);
            categoryVOList.add(categoryVO);
        }

        return ResultVOUtil.success(categoryVOList);
    }
}
