package com.okres.model.entity;

public class EditionCategory {
    private int categoryId;
    private String category;

    public EditionCategory() {
    }

    public EditionCategory(int categoryId, String category) {
        this.categoryId = categoryId;
        this.category = category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "EditionCategory{" +
                "categoryId=" + categoryId +
                ", category='" + category + '\'' +
                '}';
    }
}
