package com.sozi319.rssreader.rssfeed.rssitem.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;
import java.util.Objects;

@Entity
public class RssItem {

    @PrimaryKey
    @NotNull
    private String title;
    private String description;
    private String photoUrl;

    public RssItem(@NotNull String title, @NotNull String description, @NotNull String photoUrl) {
        this.title = title;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    @NotNull
    public String getDescription() {
        return description;
    }

    @NotNull
    public String getTitle() {
        return title;
    }

    @NotNull
    public String getPhotoUrl() {
        return photoUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RssItem rssItem = (RssItem) o;
        return title.equals(rssItem.title) &&
                Objects.equals(description, rssItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, photoUrl);
    }
}
