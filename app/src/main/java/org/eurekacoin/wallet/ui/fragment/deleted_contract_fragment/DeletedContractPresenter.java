package com.eurekanetwork.wallet.ui.fragment.deleted_contract_fragment;


import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface DeletedContractPresenter extends BaseFragmentPresenter {
    void onUnubscribeClick(String contractAddress);
}
