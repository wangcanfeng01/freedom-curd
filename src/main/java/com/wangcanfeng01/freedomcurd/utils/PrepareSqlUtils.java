package com.wangcanfeng01.freedomcurd.utils;

import com.wangcanfeng01.freedomcurd.enums.ConditionType;
import com.wangcanfeng01.freedomcurd.enums.SqlKeyword;
import com.wangcanfeng01.freedomcurd.vo.req.*;

import java.security.InvalidParameterException;
import java.util.List;

/**
 * 功能说明：
 * Created in 2020/8/15-16:20
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
public class PrepareSqlUtils {

    public static String selectSql(QueryReq req) {
        StringBuilder sql = new StringBuilder();
        sql.append(SqlKeyword.SELECT).append(" ");
        if (ObjectUtils.isEmpty(req.getColumnNames())) {
            sql.append(" * ");
        } else {
            req.getColumnNames().forEach(col -> {
                sql.append(col).append(", ");
            });
            // 删除最后一个逗号
            sql.deleteCharAt(sql.length() - 2);
        }
        sql.append(SqlKeyword.FROM).append(" ");
        if (ObjectUtils.isEmpty(req.getTableName())) {
            throw new InvalidParameterException("table name can't be null");
        }
        sql.append(req.getTableName());
        // 处理查询条件
        if (!ObjectUtils.isEmpty(req.getConditions())) {
            resolveCondition(sql, req.getConditions());
        }
        sql.append(resolvePageCondition(req.getPageSize(), req.getPageNo()));
        sql.append(";");
        return sql.toString();
    }


    public static String insertSql(InsertReq req) {
        StringBuilder sql = new StringBuilder();
        sql.append(SqlKeyword.INSERT).append(" ").append(SqlKeyword.INTO)
                .append(" ").append(req.getTableName()).append(" ");
        // 至少插入一个字段
        if (ObjectUtils.isEmpty(req.getColumnAndValues())) {
            throw new NullPointerException("at least one value to update");
        }
        sql.append("(");
        req.getColumnAndValues().forEach((k, v) -> {
            sql.append(k).append(",");
        });
        sql.deleteCharAt(sql.length() - 1);
        sql.append(") ").append(SqlKeyword.VALUES).append(" (");
        req.getColumnAndValues().forEach((k, v) -> {
            if (!(v instanceof Integer)) {
                sql.append("'").append(v).append("'").append(",");
            } else {
                sql.append(v).append(",");
            }
        });
        sql.deleteCharAt(sql.length() - 1);
        sql.append(");");
        return sql.toString();
    }

    public static String deleteSql(DeleteReq req) {
        StringBuilder sql = new StringBuilder();
        sql.append(SqlKeyword.DELETE).append(" ").append(SqlKeyword.FROM)
                .append(" ").append(req.getTableName()).append(" ");
        // 执行删除的时候必须要至少一个条件
        if (ObjectUtils.isEmpty(req.getConditions())) {
            throw new NullPointerException("at least one condition,when you want to delete something");
        }
        resolveCondition(sql, req.getConditions());
        sql.append(";");
        return sql.toString();
    }

    public static String updateSql(UpdateReq req) {
        StringBuilder sql = new StringBuilder();
        sql.append(SqlKeyword.UPDATE).append(" ").append(req.getTableName())
                .append(" ");
        // 至少更新一个字段
        if (ObjectUtils.isEmpty(req.getColumnAndValues())) {
            throw new NullPointerException("at least one value to update");
        }
        req.getColumnAndValues().forEach((k, v) -> {
            if (!(v instanceof Integer)) {
                sql.append(SqlKeyword.SET).append(" ").append(k).append("=").append(" '").append(v).append("'").append(", ");
            } else {
                sql.append(SqlKeyword.SET).append(" ").append(k).append("=").append(" ").append(v).append(", ");
            }
        });
        // 删除最后一个逗号
        sql.deleteCharAt(sql.length() - 2);
        // 处理查询条件
        resolveCondition(sql, req.getConditions());
        sql.append(";");
        return sql.toString();
    }

    private static void resolveCondition(StringBuilder sql, List<Condition> conditions) {
        sql.append(" ").append(SqlKeyword.WHERE).append(" ");
        conditions.forEach(con -> {
            if (ObjectUtils.isEmpty(con.getColumnName())) {
                throw new InvalidParameterException("condition's column name can't be null");
            }
            sql.append(" ").append(con.getColumnName());
            // 检查一下查询条件类型是否符合规则
            ConditionType type = ConditionType.checkType(con.getConditionType());
            sql.append(type.getTranslation());
            if (ObjectUtils.isEmpty(con.getConditionValue())) {
                throw new InvalidParameterException(String.format("condition [%s]'s value can't be null", con.getColumnName()));
            }
            sql.append(resolveConditionValue(type, con.getConditionValue()));
            sql.append(" ").append(SqlKeyword.AND);
        });
        sql.delete(sql.length() - 3, sql.length());
    }


    private static Object resolveConditionValue(ConditionType type, Object value) {
        if (!(value instanceof Integer)) {
            switch (type) {
                case LEFT_LIKE: {
                    return "'%" + value + "'";
                }
                case RIGHT_LIKE: {
                    return "'" + value + "%'";
                }
                case LIKE: {
                    return "'%" + value + "%'";
                }
                case IN: {
                    String temp = value.toString().replace(",", "','");
                    return "('" + temp + "')";
                }
                case EQUAL: {
                }
                default: {
                    return "'" + value + "'";
                }
            }
        } else {
            return value;
        }
    }


    public static String resolvePageCondition(long pageSize, long pageNo) {
        if (pageSize == 0) {
            pageSize = 20;
        }
        if (pageNo == 0) {
            pageNo = 1;
        }
        long limit = pageSize;
        long offset = (pageNo - 1) * pageSize;
        return " " + SqlKeyword.LIMIT + " " + limit + " " + SqlKeyword.OFFSET + " " + offset;
    }
}
