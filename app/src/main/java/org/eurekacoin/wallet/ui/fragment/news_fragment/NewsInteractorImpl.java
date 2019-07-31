package com.eurekanetwork.wallet.ui.fragment.news_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.dataprovider.rest_api.medium.MediumService;
import com.eurekanetwork.wallet.datastorage.TinyDB;
import com.eurekanetwork.wallet.model.news.News;
import com.eurekanetwork.wallet.model.news.RssFeed;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;
import rx.internal.util.SubscriptionList;

public class NewsInteractorImpl implements NewsInteractor {

    private WeakReference<Context> mContext;
    private SubscriptionList mSubscriptionList = new SubscriptionList();
    private final String MEDIUM_EUREKACOIN_CHANEL = "@eurekanetwork";

    public NewsInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public Observable<RssFeed> getMediumRssFeed() {
        return MediumService.getInstance().getRssFeed(MEDIUM_EUREKACOIN_CHANEL);
    }

    @Override
    public List<News> getNewses() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getNewsList();
    }

    @Override
    public void setNewses(List<News> newses) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        tinyDB.putNewsList(newses);
    }

    @Override
    public void unSubscribe() {
        mSubscriptionList.clear();
    }
}
