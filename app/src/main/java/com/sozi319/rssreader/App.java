package com.sozi319.rssreader;

import android.app.Application;

import com.sozi319.rssreader.di.AppComponent;
import com.sozi319.rssreader.di.DaggerAppComponent;
import com.sozi319.rssreader.rssfeed.rssitem.list.presentation.RssItemListPresenter;
import com.sozi319.rssreader.rssfeed.rssitem.list.presentation.RssItemListPresenterImpl;


public class App extends Application {

    private AppComponent component;
    RssItemListPresenter rssItemListPresenter;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerAppComponent.builder()
                .context(this)
                .build();
    }

    public RssItemListPresenter getRssItemListPresenter() {
        if (rssItemListPresenter == null) {
            rssItemListPresenter = new RssItemListPresenterImpl(component.getRssItemRepository());
        }
        return rssItemListPresenter;
    }

    public void clearUserListPresenter() {
        rssItemListPresenter = null;
    }

}
