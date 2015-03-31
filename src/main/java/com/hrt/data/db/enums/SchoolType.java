package com.hrt.data.db.enums;

public enum SchoolType {

	ELEMENTARY(0),
    MIDDLE(1),
    JUNIOR(2),
    HIGH(3);

    private final int value;

    private SchoolType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
