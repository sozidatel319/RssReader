package com.sozi319.rssreader.rssfeed.rssitem.list.presentation;

import com.sozi319.rssreader.rssfeed.rssitem.list.view.RssItemListView;

public interface RssItemListPresenter {

    void attachView(RssItemListView view);

    void detachView();

    void onFinishing();

    void onRetryButtonClicked();

    void onClickUser(RssItemUIModel rssItemUIModel);
}