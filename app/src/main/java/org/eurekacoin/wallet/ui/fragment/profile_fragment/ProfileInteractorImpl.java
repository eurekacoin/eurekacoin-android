package com.eurekanetwork.wallet.ui.fragment.profile_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.datastorage.KeyStorage;
import com.eurekanetwork.wallet.datastorage.EurekacoinSettingSharedPreference;
import com.eurekanetwork.wallet.datastorage.EurekacoinSharedPreference;
import com.eurekanetwork.wallet.datastorage.TinyDB;
import com.eurekanetwork.wallet.datastorage.listeners.LanguageChangeListener;

import io.realm.Realm;

class ProfileInteractorImpl implements ProfileInteractor {

    private Context mContext;
    private Realm mRealm;

    ProfileInteractorImpl(Context context, Realm realm) {
        mContext = context;
        mRealm = realm;
    }

    @Override
    public void clearWallet() {
        EurekacoinSharedPreference.getInstance().clear(mContext);
        KeyStorage.getInstance().clearKeyStorage();

        mRealm.removeAllChangeListeners();
        mRealm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.deleteAll();
            }
        });
        TinyDB db = new TinyDB(mContext);
        db.clearTokenList();
        db.clearContractList();
        db.clearTemplateList();
    }

    @Override
    public void setupLanguageChangeListener(LanguageChangeListener listener) {
        EurekacoinSettingSharedPreference.getInstance().addLanguageListener(listener);
    }

    @Override
    public void removeLanguageListener(LanguageChangeListener listener) {
        EurekacoinSettingSharedPreference.getInstance().removeLanguageListener(listener);
    }

    @Override
    public boolean isTouchIdEnable() {
        return EurekacoinSharedPreference.getInstance().isTouchIdEnable(mContext);
    }

    @Override
    public void saveTouchIdEnable(boolean isChecked) {
        EurekacoinSharedPreference.getInstance().saveTouchIdEnable(mContext, isChecked);
    }
}
