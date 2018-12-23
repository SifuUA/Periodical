package com.okres.model.entity.enums;

public enum Category {
    SPORT(1),
    COOKING(2),
    NEWS(3),
    NATURE(4),
    SINCE(5);


    private final int id;

    Category(int id) {
        this.id = id;
    }
}
