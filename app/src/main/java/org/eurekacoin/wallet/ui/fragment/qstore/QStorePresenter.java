package com.eurekanetwork.wallet.ui.fragment.qstore;

import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface QStorePresenter extends BaseFragmentPresenter {
    void searchItems(String seacrhBarText, boolean checked);
}
