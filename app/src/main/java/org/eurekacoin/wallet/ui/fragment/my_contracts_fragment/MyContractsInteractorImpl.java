package com.eurekanetwork.wallet.ui.fragment.my_contracts_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.dataprovider.rest_api.eurekacoin.EurekacoinService;
import com.eurekanetwork.wallet.datastorage.EurekacoinSettingSharedPreference;
import com.eurekanetwork.wallet.datastorage.TinyDB;
import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.model.gson.ExistContractResponse;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class MyContractsInteractorImpl implements MyContractsInteractor {
    private WeakReference<Context> mContext;

    public MyContractsInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public List<Contract> getContracts() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getContractList();
    }

    @Override
    public List<Contract> getContractsWithoutTokens() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getContractListWithoutToken();
    }

    @Override
    public List<Token> getTokens() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getTokenList();
    }

    @Override
    public void setContractWithoutTokens(List<Contract> contracts) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        tinyDB.putContractListWithoutToken(contracts);
    }

    @Override
    public void setTokens(List<Token> tokens) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        tinyDB.putTokenList(tokens);
    }

    @Override
    public boolean isShowWizard() {
        EurekacoinSettingSharedPreference eurekacoinSettingSharedPreference = EurekacoinSettingSharedPreference.getInstance();
        return eurekacoinSettingSharedPreference.getShowContractsDeleteUnsubscribeWizard(mContext.get());
    }

    @Override
    public void setShowWizard(boolean isShow) {
        EurekacoinSettingSharedPreference eurekacoinSettingSharedPreference = EurekacoinSettingSharedPreference.getInstance();
        eurekacoinSettingSharedPreference.setShowContractsDeleteUnsubscribeWizard(mContext.get(), isShow);
    }

    @Override
    public Observable<ExistContractResponse> isContractExist(String contractAddress) {
        return EurekacoinService.newInstance().isContractExist(contractAddress);
    }
}
