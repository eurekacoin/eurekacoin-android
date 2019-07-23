package com.eurekanetwork.wallet.ui.fragment.set_your_token_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.datastorage.FileStorageManager;
import com.eurekanetwork.wallet.model.contract.ContractMethod;

import java.lang.ref.WeakReference;

public class SetYourTokenInteractorImpl implements SetYourTokenInteractor {
    private WeakReference<Context> mContext;

    public SetYourTokenInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public ContractMethod getContractConstructor(String uiid) {
        return FileStorageManager.getInstance().getContractConstructor(mContext.get(), uiid);
    }
}
