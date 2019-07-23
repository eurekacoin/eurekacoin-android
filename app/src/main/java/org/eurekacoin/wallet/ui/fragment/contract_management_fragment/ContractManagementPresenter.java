package com.eurekanetwork.wallet.ui.fragment.contract_management_fragment;

import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface ContractManagementPresenter extends BaseFragmentPresenter {
    Contract getContractByAddress(String contractAddress);
}
