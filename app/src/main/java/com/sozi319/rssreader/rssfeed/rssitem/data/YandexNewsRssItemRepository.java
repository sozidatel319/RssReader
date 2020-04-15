package com.sozi319.rssreader.rssfeed.rssitem.data;

import com.sozi319.rssreader.rssfeed.rssitem.api.NewsYandexService;
import com.sozi319.rssreader.rssfeed.rssitem.database.RssItemDao;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.Single;

public class YandexNewsRssItemRepository implements RssItemRepository {

    private final NewsYandexService service;
    private final RssItemDao rssItemDao;

    public YandexNewsRssItemRepository(NewsYandexService service, RssItemDao rssItemDao) { //, AboutUserDao aboutUserDao
        this.service = service;
        this.rssItemDao = rssItemDao;
    }

    @Override
    public Single<List<RssItem>> getRssItems() {
        return service.getRssItems()
                .flatMap(rssFeed -> Observable.fromIterable(rssFeed.getArticleList())
                        .map(userResponse -> new RssItem(userResponse.getTitle(),userResponse.getDescription(),userResponse.getPhotoUrl()))
                        .toList())
                .doAfterSuccess(users -> {
                    System.out.println(users.get(0).getPhotoUrl());
                    rssItemDao.deleteAll();
                    rssItemDao.insert(users);
                })
                .onErrorResumeNext(error -> rssItemDao.getAll().flatMap(cachedUsers -> cachedUsers.isEmpty()
                        ? Single.error(new Exception("No users was found in cache"))
                        : Single.just(cachedUsers)));
    }
}