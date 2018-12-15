package com.okres.model.entity;

public class EditionCategory {
    private int editionId;
    private String category;

    public EditionCategory() {
    }

    public EditionCategory(int editionId, String category) {
        this.editionId = editionId;
        this.category = category;
    }

    public int getEditionId() {
        return editionId;
    }

    public void setEditionId(int editionId) {
        this.editionId = editionId;
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
                "editionId=" + editionId +
                ", category='" + category + '\'' +
                '}';
    }
}
