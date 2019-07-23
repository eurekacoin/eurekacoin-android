package com.eurekanetwork.wallet.ui.base.base_fragment;

import com.eurekanetwork.wallet.ui.base.base_activity.BasePresenter;

public interface BaseFragmentPresenter extends BasePresenter {
    void onViewCreated();

    void onDestroyView();
}
