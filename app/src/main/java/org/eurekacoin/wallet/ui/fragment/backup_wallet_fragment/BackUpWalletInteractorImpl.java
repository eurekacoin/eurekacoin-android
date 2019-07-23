package com.eurekanetwork.wallet.ui.fragment.backup_wallet_fragment;

import android.content.Context;
import android.util.Base64;

import com.eurekanetwork.wallet.datastorage.EurekacoinSharedPreference;
import com.eurekanetwork.wallet.utils.crypto.AESUtil;
import com.eurekanetwork.wallet.utils.crypto.KeyStoreHelper;

class BackUpWalletInteractorImpl implements BackUpWalletInteractor {

    private Context mContext;

    private final String EUREKACOIN_PIN_ALIAS = "eurekacoin_alias";

    BackUpWalletInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public String getPassphrase(String pin) {
       return KeyStoreHelper.getSeed(mContext, pin);
    }
}
