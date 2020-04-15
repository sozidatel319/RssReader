package com.sozi319.rssreader.rssfeed.rssitem.api;

import com.sozi319.rssreader.rssfeed.RssFeed;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface NewsYandexService {

    @GET("auto.rss")
    Single<RssFeed> getRssItems();

}
