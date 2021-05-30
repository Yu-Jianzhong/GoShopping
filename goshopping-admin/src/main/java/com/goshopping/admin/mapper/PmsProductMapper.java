package com.goshopping.admin.mapper;

import com.macro.mall.dto.PmsProductResult;
import org.apache.ibatis.annotations.Param;


/**
 * 自定义商品管理Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsProductMapper {
    /**
     * 获取商品编辑信息
     */
    PmsProductResult getUpdateInfo(@Param("id") Long id);
}
