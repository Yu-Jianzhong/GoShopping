package com.goshopping.admin.mapper;

import com.macro.mall.dto.SmsCouponParam;
import org.apache.ibatis.annotations.Param;

/**
 * 自定义优惠券管理Dao
 * Created by macro on 2018/8/29.
 */
public interface SmsCouponMapper {
    /**
     * 获取优惠券详情包括绑定关系
     */
    SmsCouponParam getItem(@Param("id") Long id);
}
