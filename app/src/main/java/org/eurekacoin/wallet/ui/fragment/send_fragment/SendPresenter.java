package com.eurekanetwork.wallet.ui.fragment.send_fragment;

import com.eurekanetwork.wallet.model.Currency;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.math.BigDecimal;

public interface SendPresenter extends BaseFragmentPresenter {
    void onResponse(String publicAddress, double amount, String tokenAddress);

    void onResponseError();

    void send();

    void updateNetworkSate(boolean networkConnectedFlag);

    void searchAndSetUpCurrency(String currency);

    void onCurrencyChoose(Currency currency);

    void handleBalanceChanges(BigDecimal unconfirmedBalance, BigDecimal balance);

    void onPinSuccess(String passphrase);
}
