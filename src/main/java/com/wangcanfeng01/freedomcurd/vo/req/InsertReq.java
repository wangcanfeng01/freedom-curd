package com.wangcanfeng01.freedomcurd.vo.req;

import java.util.Map;

/**
 * 功能说明：
 * Created in 2020/8/15-20:19
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
public class InsertReq {

    private String tableName;

    private Map<String, Object> columnAndValues;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, Object> getColumnAndValues() {
        return columnAndValues;
    }

    public void setColumnAndValues(Map<String, Object> columnAndValues) {
        this.columnAndValues = columnAndValues;
    }
}
