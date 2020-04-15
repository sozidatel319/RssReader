package com.sozi319.rssreader.rssfeed.rssitem.di;

import com.sozi319.rssreader.rssfeed.rssitem.api.NewsYandexService;
import com.sozi319.rssreader.rssfeed.rssitem.data.RssItemRepository;
import com.sozi319.rssreader.rssfeed.rssitem.data.YandexNewsRssItemRepository;
import com.sozi319.rssreader.rssfeed.rssitem.database.RssItemDao;
import dagger.Module;
import dagger.Provides;

@Module
public class RssItemModule {

    @Provides
    RssItemRepository provideUserRepository(NewsYandexService newsYandexService, RssItemDao userDao) {
        return new YandexNewsRssItemRepository(newsYandexService, userDao);
    }
}

