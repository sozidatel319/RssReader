package com.sozi319.rssreader.rssfeed.rssitem.data;

import java.util.List;

import io.reactivex.Single;

public interface RssItemRepository {

    Single<List<RssItem>> getRssItems();

}