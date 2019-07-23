package com.eurekanetwork.wallet.ui.fragment.news_fragment;

import com.eurekanetwork.wallet.model.news.News;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface NewsView extends BaseFragmentView {
    void startRefreshAnimation();

    void setAdapterNull();

    void updateNews(List<News> newses);

    void stopRefreshRecyclerAnimation();
}