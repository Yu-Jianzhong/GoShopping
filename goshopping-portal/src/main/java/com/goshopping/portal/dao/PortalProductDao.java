package com.goshopping.portal.dao;

import com.macro.mall.model.SmsCoupon;
import com.goshopping.portal.domain.CartProduct;
import com.goshopping.portal.domain.PromotionProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台系统自定义商品Dao
 * Created by macro on 2018/8/2.
 */
public interface PortalProductDao {
    CartProduct getCartProduct(@Param("id") Long id);
    List<PromotionProduct> getPromotionProductList(@Param("ids") List<Long> ids);
    List<SmsCoupon> getAvailableCouponList(@Param("productId") Long productId,@Param("productCategoryId")Long productCategoryId);
}
