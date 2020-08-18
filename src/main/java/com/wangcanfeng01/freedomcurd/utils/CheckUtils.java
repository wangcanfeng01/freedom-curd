package com.wangcanfeng01.freedomcurd.utils;

import com.wangcanfeng01.freedomcurd.vo.req.Condition;

import java.util.*;

/**
 * 功能说明：
 * Created in 2020/8/15-21:09
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
public class CheckUtils {

    public static void necessaryCondition(List<String> columnNames, List<Condition> conditions) {
        if (ObjectUtils.isEmpty(conditions)) {
            throw new NullPointerException(
                    String.format("the necessary conditions %s can't be null", columnNames.toString()));
        }
        // 采用hash查找，提升效率
        Set<String> set = new HashSet<>(conditions.size());
        conditions.forEach(con -> {
            set.add(con.getColumnName());
        });
        for (String col : columnNames) {
            if (!set.contains(col)) {
                throw new NullPointerException(String.format("the necessary condition %s can't be null", col));
            }
        }
    }


}
