package com.eurekanetwork.wallet.ui.fragment.qstore;

import android.content.Context;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.dataprovider.rest_api.eurekacoin.EurekacoinService;
import com.eurekanetwork.wallet.model.gson.qstore.QSearchItem;
import com.eurekanetwork.wallet.model.gson.qstore.QstoreItem;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class QStoreInteractorImpl implements QStoreInteractor {
    private WeakReference<Context> mContext;

    public QStoreInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public Observable<List<QSearchItem>> searchContracts(int searchOffset, String emptyType, String tag, boolean byTag) {
        return EurekacoinService.newInstance().searchContracts(searchOffset, emptyType, tag, byTag);

    }

    @Override
    public Observable<List<QstoreItem>> getWhatsNewObservable() {
        return EurekacoinService.newInstance().getWatsNew();
    }

    @Override
    public Observable<List<QstoreItem>> getTrendingNowObservable() {
        return EurekacoinService.newInstance()
                .getTrendingNow();
    }

    @Override
    public String getTrendingString() {
        return mContext.get().getString(R.string.trending_now);
    }

    @Override
    public String getWhatsNewString() {
        return mContext.get().getString(R.string.whats_new);
    }
}
