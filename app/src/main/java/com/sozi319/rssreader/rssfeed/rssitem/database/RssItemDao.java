package com.sozi319.rssreader.rssfeed.rssitem.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.sozi319.rssreader.rssfeed.rssitem.data.RssItem;
import java.util.List;
import io.reactivex.Single;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface RssItemDao {
    @Query("SELECT * FROM rssitem")
    Single<List<RssItem>> getAll();

    @Insert(onConflict = REPLACE)
    void insert(Iterable<RssItem> rssItem);

    @Query("DELETE FROM rssitem")
    void deleteAll();
}
