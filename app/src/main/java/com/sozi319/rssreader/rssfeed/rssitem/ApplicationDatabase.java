package com.sozi319.rssreader.rssfeed.rssitem;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.sozi319.rssreader.rssfeed.rssitem.data.RssItem;
import com.sozi319.rssreader.rssfeed.rssitem.database.RssItemDao;

@Database(entities = {RssItem.class}, version = 1,exportSchema = false) //, SimpleUser.class
public abstract class ApplicationDatabase extends RoomDatabase {

    public abstract RssItemDao rssItemDao();
}
