package com.sozi319.rssreader.rssfeed.rssitem.list.view;

import androidx.fragment.app.Fragment;

public interface ChangeView {

   void setFragment(int containerViewId, Fragment fragment);

    void changeFragment(Fragment fragment);
}
