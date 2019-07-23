package com.eurekanetwork.wallet.ui.fragment.news_fragment;

import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface NewsPresenter extends BaseFragmentPresenter {
    void onRefresh();

    void onNetworkStateChanged(boolean networkConnectedFlag);
}
