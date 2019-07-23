package com.eurekanetwork.wallet.ui.fragment.wallet_main_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.datastorage.TinyDB;
import com.eurekanetwork.wallet.model.contract.ContractCreationStatus;
import com.eurekanetwork.wallet.model.contract.Token;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import rx.Observable;

class WalletMainInteractorImpl implements WalletMainInteractor {

    private WeakReference<Context> mContext;

    public WalletMainInteractorImpl(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    @Override
    public Observable<List<Token>> getTokensObservable() {
        return Observable.fromCallable(new Callable<List<Token>>() {
            @Override
            public List<Token> call() throws Exception {
                TinyDB tinyDB = new TinyDB(mContext.get());
                List<Token> tokenList = tinyDB.getTokenList();
                List<Token> tokens = new ArrayList<>();
                for (Token token : tokenList) {
                    if (token.getCreationStatus().equals(ContractCreationStatus.Created) && token.isSubscribe()) {
                        tokens.add(token);
                    }
                }
                tokenList.clear();
                return tokens;
            }
        });
    }
}
