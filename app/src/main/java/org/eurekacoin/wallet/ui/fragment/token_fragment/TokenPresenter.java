package com.eurekanetwork.wallet.ui.fragment.token_fragment;

import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface TokenPresenter extends BaseFragmentPresenter {
    Token getToken();

    void setToken(Token token);

    String getAbi();

    void onDecimalsPropertySuccess(String value);

    String onTotalSupplyPropertySuccess(Token token, String value);

    void onLastItem(int currentItemCount);

    void onTransactionClick(String txHash);

    void onNetworkStateChanged(boolean networkConnectedFlag);
}
