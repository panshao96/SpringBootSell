package com.imooc.sell.controller;

import com.imooc.sell.utils.KeyUtil;
import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.form.ProductForm;
import com.imooc.sell.service.CategoryService;
import com.imooc.sell.service.InfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private CategoryService categoryService;

    /**
     *列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list (@RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "size", defaultValue = "10") Integer size,
                        Map<String, Object> map) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<ProductInfo> productInfoPage = infoService.findAll(pageRequest);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("/product/list", map);
    }

    /**
     * 商品上架
     * @param infoId
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("infoId") String infoId,
                               Map<String, Object> map) {
        try {
            infoService.onSale(infoId);
        } catch (Exception e) {
            map.put("msg" ,e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("/common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("/common/success", map);
    }

    /**
     * 商品下架
     * @param infoId
     * @param map
     * @return
     */
    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("infoId") String infoId,
                               Map<String, Object> map) {
        try {
            infoService.offSale(infoId);
        } catch (Exception e) {
            map.put("msg" ,e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("/common/error", map);
        }

        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("/common/success", map);
    }

    /**
     *新增或修改
     * @param infoId    非必传
     * @param map
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "infoId", required = false) String infoId,
                      Map<String, Object> map) {
        if (!StringUtils.isEmpty(infoId)) {
            ProductInfo productInfo = infoService.findOne(infoId);
            map.put("productInfo", productInfo);
        }

        //查询所有类目
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("/product/index", map);
    }


    /**
     * 保存
     * @param form
     * @param bindingResult
     * @param map
     * @return
     */

    /**
     * @CachePut(cacheNames = "#Name", key = "#Value, condition = "#sellerId.length() > 3"
     * , unless = "#result.getCode() != 0 " ")
     * name和key都可以动态变化
     * condition可用于判断，若条件成立才会进行缓存
     * unless可从返回的结果中获取数据并判断，不成立就缓存
     */

    @PostMapping("/save")
//    @CachePut(cacheNames = "product", key = "123")
    @CacheEvict(cacheNames = "product", key = "123")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index1");
            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            if (!StringUtils.isEmpty(form.getInfoId())) {
                productInfo = infoService.findOne(form.getInfoId());
                BeanUtils.copyProperties(form, productInfo);
            }else {
                BeanUtils.copyProperties(form, productInfo);
                productInfo.setInfoId(KeyUtil.genUniqueKey());
            }
            infoService.save(productInfo);
        }catch (Exception e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
