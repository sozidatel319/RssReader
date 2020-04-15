package com.sozi319.rssreader;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.sozi319.rssreader.rssfeed.rssitem.list.view.RssItemListFragment;
import com.sozi319.rssreader.rssfeed.rssitem.list.view.ViewPresenter;

public class MainActivity extends AppCompatActivity {
    ViewPresenter viewPresenter = new ViewPresenter(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            viewPresenter.setFragment(R.id.container,new RssItemListFragment());
        }

    }
}
