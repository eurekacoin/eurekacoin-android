package com.eurekanetwork.wallet.ui.fragment.confirm_passphrase_fragment;


import android.content.Context;

import com.eurekanetwork.wallet.datastorage.KeyStorage;
import com.eurekanetwork.wallet.datastorage.EurekacoinSharedPreference;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

import rx.Observable;

public class ConfirmPassphraseInteractorImpl implements ConfirmPassphraseInteractor {

    WeakReference<Context> mContext;

    ConfirmPassphraseInteractorImpl(Context context){
        mContext = new WeakReference<Context>(context);
    }

    @Override
    public Observable<String> createWallet(final String passphrase) {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return KeyStorage.getInstance().loadWallet(passphrase);
            }
        });
    }

    @Override
    public void setKeyGeneratedInstance(boolean isKeyGenerated) {
        EurekacoinSharedPreference.getInstance().setKeyGeneratedInstance(mContext.get(), isKeyGenerated);
    }
}
