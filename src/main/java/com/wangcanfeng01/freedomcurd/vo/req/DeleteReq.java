package com.wangcanfeng01.freedomcurd.vo.req;

import java.util.List;

/**
 * 功能说明：
 * Created in 2020/8/15-20:27
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
public class DeleteReq {
    private String tableName;

    private List<Condition> conditions;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}
