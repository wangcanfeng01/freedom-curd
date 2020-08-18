package com.wangcanfeng01.freedomcurd.vo.req;

import java.util.List;
import java.util.Map;

/**
 * 功能说明：
 * Created in 2020/8/15-20:27
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
public class UpdateReq {

    private String tableName;

    private Map<String, Object> columnAndValues;

    private List<Condition> conditions;

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

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}
