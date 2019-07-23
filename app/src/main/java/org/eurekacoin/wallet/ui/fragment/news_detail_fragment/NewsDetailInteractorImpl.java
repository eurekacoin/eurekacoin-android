package com.eurekanetwork.wallet.ui.fragment.news_detail_fragment;

import android.content.Context;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import com.eurekanetwork.wallet.datastorage.NewsStorage;
import com.eurekanetwork.wallet.model.news.News;

import java.lang.ref.WeakReference;

public class NewsDetailInteractorImpl implements NewsDetailInteractor {

    WeakReference<Context> mContext;

    public NewsDetailInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public News getNews(int newsPosition) {
        return NewsStorage.newInstance().getNews(newsPosition);
    }
}
