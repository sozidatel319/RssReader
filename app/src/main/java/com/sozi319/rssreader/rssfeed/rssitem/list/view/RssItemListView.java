package com.sozi319.rssreader.rssfeed.rssitem.list.view;

import com.sozi319.rssreader.rssfeed.rssitem.list.presentation.RssItemUIModel;
import java.util.List;

public interface RssItemListView {

    void showUserList(List<RssItemUIModel> users);

    void showErrorMessage(String errorMessage);

    void setProgressVisibility(boolean visible);

    void setRetryButtonVisibility(boolean visible);

    void openUpperScreen(String userName);

}