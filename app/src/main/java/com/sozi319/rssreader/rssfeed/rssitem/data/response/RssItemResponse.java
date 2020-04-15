package com.sozi319.rssreader.rssfeed.rssitem.data.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "item", strict = false)
public class RssItemResponse {


    @Element(name = "title")
    private String title;

    @Element(name = "description")
    private String description;

    @Element(name = "link")
    private String photoUrl;

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
