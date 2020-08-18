package com.wangcanfeng01.freedomcurd.vo.req;

import java.util.List;

/**
 * 功能说明：
 * Created in 2020/8/15-15:44
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
public class QueryReq {
    private String tableName;

    private List<String> columnNames;

    private List<Condition> conditions;

    private boolean needCamel;

    private long pageSize;

    private long pageNo;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
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

    public boolean isNeedCamel() {
        return needCamel;
    }

    public void setNeedCamel(boolean needCamel) {
        this.needCamel = needCamel;
    }
}
