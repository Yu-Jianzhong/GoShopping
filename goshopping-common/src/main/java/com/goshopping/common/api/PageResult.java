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
@ApiModel("分页返回结果")
public class PageResult<T> implements IPage<T> {

    private static final long serialVersionUID = 8545996863226528798L;

    @ApiModelProperty("数据列表")
    private List<T> records = Collections.emptyList();

    @ApiModelProperty("总数")
    private long total = 0;

    @ApiModelProperty("页码，默认1")
    private long pageNum = 1;

    @ApiModelProperty(value = "每页显示条数，默认 10")
    private long pageSize = 10;

    /**
     * 分页构造函数
     *
     * @param pageNum 当前页
     * @param pageSize  每页显示条数
     */
    public PageResult(long pageNum, long pageSize) {
        this(pageNum, pageSize, 0);
    }

    public PageResult(long pageNum, long pageSize, long total) {
        this(pageNum, pageSize, total, true);
    }

    public PageResult(long pageNum, long pageSize, boolean isSearchCount) {
        this(pageNum, pageSize, 0, isSearchCount);
    }

    public PageResult(long pageNum, long pageSize, long total, boolean isSearchCount) {
        if (pageNum > 1) {
            this.pageNum = pageNum;
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
        return this.pageNum > 1;
    }

    /**
     * 是否存在下一页
     *
     * @return true / false
     */
    public boolean hasNext() {
        return this.pageNum < this.getPages();
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
        return this.pageNum;
    }

    @Override
    public PageResult<T> setCurrent(long current) {
        this.pageNum = current;
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
        return total >= 0;
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
        this.setPageNum(result.getPageNum());
        this.setPageSize(result.getPageSize());
        this.setTotal(result.getTotal());
        this.setCurrent(result.getCurrent());
    }
}
