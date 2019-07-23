package com.eurekanetwork.wallet.ui.fragment.eurekacoin_cash_management_fragment;

import com.eurekanetwork.wallet.model.gson.UnspentOutput;

import java.util.List;

import rx.Observable;

public interface AddressListInteractor {
    List<String> getAddresses();

    Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses);
}
