package com.chaomeis.sparrowbeauty.common;

import com.github.pagehelper.Page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class PageRespDto <T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private long total;        //总记录数
    private int pageNum;    // 第几页
    private int pageSize;    // 每页记录数
    private int pages;        // 总页数
    private int size;        // 当前页的数量 <= pageSize，该属性来自ArrayList的size属性

    private List<T> list;    //结果集

    //搜索时动态参数（请求时匹配）
    private Map<String,Object> condition;//动态参数


    public PageRespDto() {
    }

    /**
     * 包装Page对象，因为直接返回Page对象，在JSON处理以及其他情况下会被当成List来处理，
     * 而出现一些问题。
     * @param list          page结果
     */
    public PageRespDto(List<T> list) {

        if (list instanceof Page) {

            Page<T> page = (Page<T>) list;

            this.pageNum = page.getPageNum();
            this.pageSize = page.getPageSize();
            this.total = page.getTotal();
            this.pages = page.getPages();
            this.list = page;
            this.size = page.size();
        }
    }

    /**
     * 上一页
     * @return
     */
    public int getPreviousPage(){
        return this.pageNum > 1 ? this.pageNum -1 : 1;
    }

    /**
     * 下一页
     * @return
     */
    public int getNextPage(){
        return this.pageNum <  this.pages ? this.pageNum + 1 : this.pages;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }
}
