package com.unibell.client.entity;

/**
 * Тип контакта
 */
public enum ContactTypeEnum {

    PHONE("Телефон"),
    EMAIL("Email"),
    UNKNOWN("Неизвестно");

    private String value;

    ContactTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ContactTypeEnum getEnumByValue(String str) {
        if (str.equals(PHONE.value)) {
            return PHONE;
        } else if (str.equals(EMAIL.value)) {
            return EMAIL;
        } else {
            return UNKNOWN;
        }
    }

}
