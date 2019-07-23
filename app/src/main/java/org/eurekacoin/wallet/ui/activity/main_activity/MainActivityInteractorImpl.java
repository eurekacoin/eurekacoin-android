package com.eurekanetwork.wallet.ui.activity.main_activity;

import android.content.Context;

import com.eurekanetwork.wallet.dataprovider.rest_api.eurekacoin.EurekacoinService;
import com.eurekanetwork.wallet.datastorage.KeyStorage;
import com.eurekanetwork.wallet.datastorage.EurekacoinSettingSharedPreference;
import com.eurekanetwork.wallet.datastorage.EurekacoinSharedPreference;
import com.eurekanetwork.wallet.datastorage.listeners.LanguageChangeListener;
import com.eurekanetwork.wallet.model.gson.DGPInfo;
import com.eurekanetwork.wallet.model.gson.FeePerKb;

import java.math.BigDecimal;

import rx.Observable;

class MainActivityInteractorImpl implements MainActivityInteractor {

    private Context mContext;

    private boolean isDGPInfoLoaded = false;
    private boolean isFeePerkbLoaded = false;

    MainActivityInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public boolean getKeyGeneratedInstance() {
        return EurekacoinSharedPreference.getInstance().getKeyGeneratedInstance(mContext);
    }

    @Override
    public void clearStatic() {
        KeyStorage.getInstance().clearKeyStorage();
    }

    @Override
    public Observable<DGPInfo> getDGPInfo() {
        return EurekacoinService.newInstance().getDGPInfo();
    }

    @Override
    public boolean isDGPInfoLoaded() {
        return isDGPInfoLoaded;
    }

    @Override
    public boolean isFeePerkbLoaded() {
        return isFeePerkbLoaded;
    }

    @Override
    public void addLanguageChangeListener(LanguageChangeListener languageChangeListener) {
        EurekacoinSettingSharedPreference.getInstance().addLanguageListener(languageChangeListener);
    }

    @Override
    public void removeLanguageChangeListener(LanguageChangeListener languageChangeListener) {
        EurekacoinSettingSharedPreference.getInstance().removeLanguageListener(languageChangeListener);
    }

    @Override
    public Observable<FeePerKb> getFeePerKb() {
        return EurekacoinService.newInstance().getEstimateFeePerKb(2);
    }

    @Override
    public void setDGPInfo(DGPInfo dgpInfo) {
        isDGPInfoLoaded = true;
        EurekacoinSharedPreference.getInstance().setMinGasPrice(mContext, dgpInfo.getMingasprice());
    }

    @Override
    public void setFeePerKb(FeePerKb feePerKb) {
        isFeePerkbLoaded = true;
        EurekacoinSettingSharedPreference eurekacoinSettingSharedPreference = EurekacoinSettingSharedPreference.getInstance();
        eurekacoinSettingSharedPreference.setFeePerKb(mContext, feePerKb.getFeePerKb().setScale(5, BigDecimal.ROUND_HALF_DOWN).toPlainString());
    }
}
