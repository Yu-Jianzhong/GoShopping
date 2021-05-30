package com.goshopping.admin.mapper;

import com.macro.mall.model.PmsMemberPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义会员价格Dao
 * Created by macro on 2018/4/26.
 */
public interface PmsMemberPriceMapper {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsMemberPrice> memberPriceList);
}
