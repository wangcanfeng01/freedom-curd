package com.wangcanfeng01.freedomcurd.vo.resp;

import java.util.List;

/**
 * 功能说明：
 * Created in 2020/8/16-12:42
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
public class PageInfo<T> {

    private long total;

    private long pageSize;

    private long pageNo;

    private List<T> result;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
