package com.eurekanetwork.wallet.ui.fragment.my_contracts_fragment;

import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.model.gson.ExistContractResponse;

import java.util.List;

import rx.Observable;

public interface MyContractsInteractor {
    List<Contract> getContracts();

    List<Contract> getContractsWithoutTokens();

    List<Token> getTokens();

    void setContractWithoutTokens(List<Contract> contracts);

    void setTokens(List<Token> tokens);

    boolean isShowWizard();

    void setShowWizard(boolean isShow);

    Observable<ExistContractResponse> isContractExist(String contractAddress);
}
