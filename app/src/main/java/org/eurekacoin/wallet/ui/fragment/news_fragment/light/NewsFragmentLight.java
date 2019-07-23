package com.eurekanetwork.wallet.ui.fragment.news_fragment.light;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.model.news.News;
import com.eurekanetwork.wallet.ui.activity.main_activity.MainActivity;
import com.eurekanetwork.wallet.ui.fragment.news_fragment.NewsFragment;

import java.util.List;

public class NewsFragmentLight extends NewsFragment {
    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_news_light;
    }

    @Override
    public void initializeViews() {
        ((MainActivity) getActivity()).showBottomNavigationView(com.eurekanetwork.wallet.R.color.title_color_light);
        super.initializeViews();
    }

    @Override
    public void updateNews(List<News> newses) {
        mNewsAdapter = new NewsAdapter(newses, R.layout.item_news_light);
        mRecyclerView.setAdapter(mNewsAdapter);
        mSwipeRefreshLayout.setRefreshing(false);
    }
}