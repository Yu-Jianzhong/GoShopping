package com.goshopping.admin.mapper;

import com.macro.mall.model.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义优惠券和商品关系关系Dao
 * Created by macro on 2018/8/28.
 */
public interface SmsCouponProductRelationMapper {
    /**
     * 批量创建
     */
    int insertList(@Param("list")List<SmsCouponProductRelation> productRelationList);
}
