package com.eurekanetwork.wallet.ui.fragment.store_categories;

import com.eurekanetwork.wallet.model.gson.QstoreContractType;

import java.util.List;

import rx.Observable;

public interface StoreCategoriesInteractor {
    Observable<List<QstoreContractType>> contractTypesObservable();
}
