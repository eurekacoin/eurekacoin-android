package com.eurekanetwork.wallet.ui.fragment.touch_id_preference_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.datastorage.EurekacoinSharedPreference;

import java.lang.ref.WeakReference;

public class TouchIDInterractorImpl implements TouchIDInterractor {
    private WeakReference<Context> mContext;

    public TouchIDInterractorImpl(Context context) {
        this.mContext = new WeakReference<>(context);
    }

    @Override
    public void saveTouchIDEnabled() {
        EurekacoinSharedPreference.getInstance().saveTouchIdEnable(mContext.get(), true);
    }
}
