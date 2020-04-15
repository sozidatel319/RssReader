package com.sozi319.rssreader.di;

import android.content.Context;
import androidx.room.Room;
import com.sozi319.rssreader.rssfeed.rssitem.ApplicationDatabase;
import com.sozi319.rssreader.rssfeed.rssitem.database.RssItemDao;
import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {
    @Provides
    static RssItemDao providesUserDao(ApplicationDatabase database) {
        return database.rssItemDao();
    }

    @Provides
    static ApplicationDatabase providesApplicationDatabase(Context context) {
        return Room.databaseBuilder(context, ApplicationDatabase.class, "database").build();
    }
}
