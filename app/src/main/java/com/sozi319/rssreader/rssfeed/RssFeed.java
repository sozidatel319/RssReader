package com.sozi319.rssreader.rssfeed;

import com.sozi319.rssreader.rssfeed.rssitem.data.response.RssItemResponse;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Path;
import org.simpleframework.xml.Root;
import java.util.List;

@Root(name="rss", strict=false)
public class RssFeed {

    @Element(name="title")
    @Path("channel")
    private String channelTitle;

    @ElementList(name="item", inline=true)
    @Path("channel")
    private List<RssItemResponse> articleList;

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public List<RssItemResponse> getArticleList() {
        return articleList;
    }
}
