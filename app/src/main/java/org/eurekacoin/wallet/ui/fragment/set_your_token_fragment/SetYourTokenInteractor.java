package com.eurekanetwork.wallet.ui.fragment.set_your_token_fragment;

import com.eurekanetwork.wallet.model.contract.ContractMethod;

public interface SetYourTokenInteractor {
    ContractMethod getContractConstructor(String uiid);
}
