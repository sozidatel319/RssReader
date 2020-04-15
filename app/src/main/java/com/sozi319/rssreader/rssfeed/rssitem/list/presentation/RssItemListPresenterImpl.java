package com.sozi319.rssreader.rssfeed.rssitem.list.presentation;

import com.sozi319.rssreader.rssfeed.rssitem.data.RssItemRepository;
import com.sozi319.rssreader.rssfeed.rssitem.list.view.RssItemListView;
import java.util.List;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RssItemListPresenterImpl implements RssItemListPresenter {

    private RssItemRepository rssItemRepository;
    private RssItemListView view;
    private Disposable disposable;
    private List<RssItemUIModel> rssItemList;

    public RssItemListPresenterImpl(RssItemRepository rssItemRepository) {
        this.rssItemRepository = rssItemRepository;
    }

    @Override
    public void attachView(RssItemListView view) {
        this.view = view;
        if (isLoading()) {
            view.setProgressVisibility(true);
            return;
        }

        if (rssItemList != null) {
            view.showUserList(rssItemList);
        } else {
            loadRssItems();
        }
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onFinishing() {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override
    public void onRetryButtonClicked() {
        view.setRetryButtonVisibility(false);
        loadRssItems();
    }

    @Override
    public void onClickUser(RssItemUIModel rssItemUIModel) {
        view.openUpperScreen(rssItemUIModel.getTitle());
    }

    private void loadRssItems() {
        if (isLoading()) {
            throw new RuntimeException("Rssitems loading is already in progress");
        }
        disposable = rssItemRepository.getRssItems()
                .flatMap(rssItems -> Observable.fromIterable(rssItems)
                .map(rssItem -> new RssItemUIModel(rssItem.getDescription(), rssItem.getTitle(),rssItem.getPhotoUrl()))
                .toList())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> view.setProgressVisibility(true))
                .doOnSuccess(list -> rssItemList = list)
                .filter(users -> view != null)
                .doAfterTerminate(() -> view.setProgressVisibility(false))
                .subscribe(rssItemUI -> view.showUserList(rssItemUI),
                        error -> {
                            view.showErrorMessage(error.getMessage());
                            view.setRetryButtonVisibility(true);
                        });
    }

    private boolean isLoading() {
        return disposable != null && !disposable.isDisposed();
    }

}