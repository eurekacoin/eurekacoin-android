package com.eurekanetwork.wallet.ui.fragment.wallet_fragment;

import com.eurekanetwork.wallet.model.gson.history.History;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface WalletPresenter extends BaseFragmentPresenter {

    void onTransactionClick(String txHash);

    void onLastItem(int currentItemCount);

    void onNetworkStateChanged(boolean networkConnectedFlag);

    void onNewHistory(History history);

    boolean getVisibility();

    void updateVisibility(boolean value);

}
