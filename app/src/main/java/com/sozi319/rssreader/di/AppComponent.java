package com.sozi319.rssreader.di;

import android.content.Context;
import com.sozi319.rssreader.rssfeed.rssitem.data.RssItemRepository;
import com.sozi319.rssreader.rssfeed.rssitem.di.RssItemModule;
import dagger.BindsInstance;
import dagger.Component;

@PerApplication
@Component(modules = {NetworkModule.class, RssItemModule.class, DatabaseModule.class})
public interface AppComponent {

    RssItemRepository getRssItemRepository();

    @Component.Builder
    interface Builder{
        AppComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}
