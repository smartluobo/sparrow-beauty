package com.chaomeis.sparrowbeauty.common;

import java.io.Serializable;

public class PageReqVO<T> implements Serializable {

    private Integer pageSize;//每页显示条数

    private Integer pageNum;//当前页面

    private String orderCode;//排序代号

    private T condition;//动态参数

    public Integer getPageSize() {
        if(null == pageSize) {
            this.pageSize = 10;
        }else if (pageSize >= 1000 ){ // 最多请求1000条
            this.pageSize = 1000;
        }else {
            this.pageSize = pageSize;
        }
        return pageSize;

    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public Integer getPageNum() {
        if(null == pageNum || pageNum <= 0) {
            this.pageNum = 1;
        }else {
            this.pageNum = pageNum;
        }
        return pageNum;
    }
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    public String getOrderCode() {
        return orderCode;
    }
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
    public T getCondition() {
        return condition;
    }
    public void setCondition(T condition) {
        this.condition = condition;
    }
}
