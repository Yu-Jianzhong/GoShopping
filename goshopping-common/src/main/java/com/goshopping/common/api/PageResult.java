package com.goshopping.common.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

/**
 * 分页返回结果
 *
 * @author yujianzhong
 * @date 2020/5/26
 */
@Data
@NoArgsConstructor
@ApiModel(value = "分页返回结果", description = "分页返回结果")
public class PageResult<T> implements IPage<T> {

    private static final long serialVersionUID = 8545996863226528798L;

    @ApiModelProperty(value = "查询数据列表")
    private List<T> records = Collections.emptyList();

    @ApiModelProperty(value = "总数")
    private long total = 0;

    @ApiModelProperty(value = "当前页")
    private long pageIndex = 1;

    @ApiModelProperty(value = "每页显示条数，默认 10")
    private long pageSize = 10;

    @ApiModelProperty(value = "是否为最后一页（1：是，0：否）")
    private int isLastPage;

    /**
     * 分页构造函数
     *
     * @param pageIndex 当前页
     * @param pageSize  每页显示条数
     */
    public PageResult(long pageIndex, long pageSize) {
        this(pageIndex, pageSize, 0);
    }

    public PageResult(long pageIndex, long pageSize, long total) {
        this(pageIndex, pageSize, total, true);
    }

    public PageResult(long pageIndex, long pageSize, boolean isSearchCount) {
        this(pageIndex, pageSize, 0, isSearchCount);
    }

    public static <T> PageResult<T> create(long pageIndex, long pageSize, boolean isSearchCount) {
        return new PageResult<>(pageIndex, pageSize, 0, isSearchCount);
    }

    public static <T> PageResult<T> create(long pageIndex, long pageSize) {
        return new PageResult<>(pageIndex, pageSize, 0, false);
    }

    public PageResult(long pageIndex, long pageSize, long total, boolean isSearchCount) {

        if (pageIndex > 1) {
            this.pageIndex = pageIndex;
        }
        this.pageSize = pageSize;
        this.total = total;
    }

    /**
     * 是否存在上一页
     *
     * @return true / false
     */
    public boolean hasPrevious() {
        return this.pageIndex > 1;
    }

    /**
     * 是否存在下一页
     *
     * @return true / false
     */
    public boolean hasNext() {
        return this.pageIndex < this.getPages();
    }

    @Override
    public List<T> getRecords() {
        return this.records;
    }

    @Override
    public PageResult<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Override
    public long getTotal() {
        return this.total;
    }

    @Override
    public PageResult<T> setTotal(long total) {
        this.total = total;
        this.isLastPage = this.hasNext() ? 0 : 1;
        return this;
    }

    @Override
    @JsonIgnore
    public long getSize() {
        return this.pageSize;
    }

    @Override
    public PageResult<T> setSize(long size) {
        this.pageSize = size;
        return this;
    }

    @Override
    @JsonIgnore
    public long getCurrent() {
        return this.pageIndex;
    }

    @Override
    public PageResult<T> setCurrent(long current) {
        this.pageIndex = current;
        return this;
    }

    @Override
    @JsonIgnore
    public List<OrderItem> orders() {
        return Collections.emptyList();
    }

    @Override
    @JsonIgnore
    public boolean optimizeCountSql() {
        return false;
    }

    @Override
    @JsonIgnore
    public boolean isSearchCount() {
        if (total < 0) {
            return false;
        }
        return true;
    }

    @Override
    @JsonIgnore
    public void hitCount(boolean hit) {
    }

    @Override
    @JsonIgnore
    public boolean isHitCount() {
        return false;
    }

    /**
     * 当前分页总页数
     */
    @Override
    @JsonIgnore
    public long getPages() {
        if (getSize() == 0) {
            return 0L;
        }
        long pages = getTotal() / getSize();
        if (getTotal() % getSize() != 0) {
            pages++;
        }
        return pages;
    }

    /**
     * 设置参数
     *
     * @param result
     */
    public void setParams(PageResult<?> result) {
        this.setPageIndex(result.getPageIndex());
        this.setPageSize(result.getPageSize());
        this.setIsLastPage(result.getIsLastPage());
        this.setTotal(result.getTotal());
        this.setCurrent(result.getCurrent());
    }
}
