package com.eurekanetwork.wallet.ui.fragment.eurekacoin_cash_management_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.dataprovider.rest_api.eurekacoin.EurekacoinService;
import com.eurekanetwork.wallet.datastorage.KeyStorage;

import com.eurekanetwork.wallet.model.gson.UnspentOutput;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;

public class AddressListInteractorImpl implements AddressListInteractor {

    AddressListInteractorImpl() {
    }

    @Override
    public List<String> getAddresses() {
        return KeyStorage.getInstance().getAddresses();
    }

    @Override
    public Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses) {
        return EurekacoinService.newInstance().getUnspentOutputsForSeveralAddresses(addresses);
    }
}
