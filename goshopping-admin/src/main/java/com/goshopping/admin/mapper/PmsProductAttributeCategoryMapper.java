package com.goshopping.admin.mapper;

import com.macro.mall.dto.PmsProductAttributeCategoryItem;

import java.util.List;

/**
 * 自定义商品属性分类Dao
 * Created by macro on 2018/5/24.
 */
public interface PmsProductAttributeCategoryMapper {
    /**
     * 获取包含属性的商品属性分类
     */
    List<PmsProductAttributeCategoryItem> getListWithAttr();
}
