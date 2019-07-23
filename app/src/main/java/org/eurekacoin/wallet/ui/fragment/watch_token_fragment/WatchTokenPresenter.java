package com.eurekanetwork.wallet.ui.fragment.watch_token_fragment;

import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface WatchTokenPresenter extends BaseFragmentPresenter {

    void onOkClick(String name, String address);

    void onContractAddressEntered(String contractAddress);

}
