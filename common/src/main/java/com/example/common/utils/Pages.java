package com.example.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 分页类
 *
 * @param <T>
 */
@SuppressWarnings("ALL")
public class Pages<T> implements Serializable {

    private static final long serialVersionUID = 2241880346419791036L;

    //起始项目
    private Integer startItem;

    //页面大小
    private Integer pageSize;

    //上一页码
    private Integer previousPage;

    //当前页码
    private Integer currentPage;

    //下一页码
    private Integer nextPage;

    //条目总数
    private Integer totalCount;

    //总页数
    private Integer totalPage;

    //条目列表
    private List<T> list;

    /**
     * 设置当前页、当前条、上一页、页面大小
     *
     * @param currentPage 当前页
     * @param pageSize    页面大小
     * @return 起始条目
     */
    public Integer setPageInfo(Integer currentPage, Integer pageSize) {
        setStartItem(currentPage, pageSize);
        setPageSize(pageSize);
        return getStartItem();
    }

    /**
     * 计算分页时起始条目，起始页码为1
     *
     * @param startPage 起始页码
     * @param pageSize  页面大小
     */
    private void setStartItem(Integer startPage, Integer pageSize) {
        if (startPage > 0 && pageSize > 0) {
            setCurrentPage(startPage);
            this.startItem = (startPage - 1) * pageSize;
        } else {
            this.startItem = 0;
        }
    }

    /**
     * 为页面大小赋值，值错误时赋为1
     *
     * @param pageSize 页面大小
     */
    private void setPageSize(Integer pageSize) {
        if (pageSize > 0) {
            this.pageSize = pageSize;
        } else {
            this.pageSize = 1;
        }
    }

    /**
     * 设置当前页码，同时赋值上一页页码，当前页赋1值时为上一页赋1值
     *
     * @param currentPage 当前页码
     */
    private void setCurrentPage(Integer currentPage) {
        if (currentPage > 0) {
            this.currentPage = currentPage;
            if (currentPage == 1) {
                this.previousPage = 1;
            } else {
                this.previousPage = currentPage - 1;
            }
        } else {
            this.currentPage = 1;
            this.previousPage = 1;
        }
    }

    /**
     * 设置总条目数，同时设定下一页码和总页数
     *
     * @param totalCount 总条目数
     */
    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        if ((totalCount - pageSize) > startItem) {
            this.nextPage = currentPage + 1;
        } else {
            this.nextPage = currentPage;
        }
        this.totalPage = (totalCount + pageSize - 1) / pageSize;
    }

    public int createSubEnd() {
        if (totalCount < startItem + pageSize) {
            return totalCount;
        }
        return startItem + pageSize;
    }

    public int createSubStart() {
        int start = startItem;
        if (start > currentPage)
            start = start - pageSize;
        if (start < 0)
            return 0;
        return start;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getStartItem() {
        return startItem;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPreviousPage() {
        return previousPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getNextPage() {
        return nextPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public List<T> getList() {
        return list;
    }

}
