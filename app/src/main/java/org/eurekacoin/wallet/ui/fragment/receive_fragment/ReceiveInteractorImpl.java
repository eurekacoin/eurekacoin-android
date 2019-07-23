package com.eurekanetwork.wallet.ui.fragment.receive_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.datastorage.KeyStorage;

import java.math.BigDecimal;

class ReceiveInteractorImpl implements ReceiveInteractor {

    private Context mContext;

    ReceiveInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public String getCurrentReceiveAddress() {
        return KeyStorage.getInstance().getCurrentAddress();
    }

    @Override
    public String formatReceiveAddress(String addr) {
        return String.format("eurekacoin:%s?", addr);
    }

    @Override
    public String formatAmount(String amount) {
        return String.format("amount=%s&", amount);
    }

    @Override
    public String formatTokenAddress(String addr) {
        return String.format("&tokenAddress=%s", addr);
    }

}