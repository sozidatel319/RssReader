package com.sozi319.rssreader.rssfeed.rssitem.list.presentation;

import java.util.Objects;

public class RssItemUIModel {
    private String title;
    private String description;
    private String photoUrl;

    public RssItemUIModel(String title, String description, String photoUrl) {
        this.title = title;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RssItemUIModel that = (RssItemUIModel) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(photoUrl, that.photoUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, photoUrl);
    }
}