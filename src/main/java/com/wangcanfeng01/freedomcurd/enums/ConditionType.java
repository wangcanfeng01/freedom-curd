package com.wangcanfeng01.freedomcurd.enums;

/**
 * 功能说明：
 * Created in 2020/8/15-16:05
 *
 * @author wangcanfeng
 * @since 2.0.0
 */
public enum ConditionType {
    LEFT_LIKE(" LIKE "),
    RIGHT_LIKE(" LIKE "),
    LIKE(" LIKE "),
    EQUAL(" = "),
    IN(" IN ");

    private String translation;

    ConditionType(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    public static ConditionType checkType(String trans) {
        for (ConditionType type : values()) {
            if (type.name().equalsIgnoreCase(trans)) {
                return type;
            }
        }
        throw new UnsupportedOperationException(String.format("sql condition type [%s] is unsupported" +
                ", you can try %s", trans, valueStrs()));
    }

    private static String valueStrs() {
        StringBuilder sb = new StringBuilder();
        for (ConditionType type : values()) {
            sb.append(type.name()).append(" ");
        }
        return sb.toString();
    }
}
