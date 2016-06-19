package com.payitezy.apiobjects;

public class FlipkartCategory {
    private String categoryName;
    private String categoryLink;

    public String getCategoryLink() {
        return categoryLink;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryLink(final String categoryLink) {
        this.categoryLink = categoryLink;
    }

    public void setCategoryName(final String categoryName) {
        this.categoryName = categoryName;
    }

}
