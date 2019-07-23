package com.eurekanetwork.wallet.ui.fragment.news_detail_fragment;

import com.eurekanetwork.wallet.model.news.News;

public interface NewsDetailInteractor {
    News getNews(int newsPosition);
}
