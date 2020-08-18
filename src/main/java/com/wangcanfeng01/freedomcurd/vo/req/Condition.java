package com.wangcanfeng01.freedomcurd.vo.req;

/**
 * 功能说明：
 * Created in 2020/8/15-15:58
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
public class Condition {

    private String conditionType;

    private String columnName;

    private Object conditionValue;

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Object getConditionValue() {
        return conditionValue;
    }

    public void setConditionValue(Object conditionValue) {
        this.conditionValue = conditionValue;
    }
}
