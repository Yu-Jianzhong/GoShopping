package com.goshopping.admin.mapper;

import com.macro.mall.model.CmsSubjectProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品和专题关系操作Dao
 * Created by macro on 2018/4/26.
 */
public interface CmsSubjectProductRelationMapper {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<CmsSubjectProductRelation> subjectProductRelationList);
}
