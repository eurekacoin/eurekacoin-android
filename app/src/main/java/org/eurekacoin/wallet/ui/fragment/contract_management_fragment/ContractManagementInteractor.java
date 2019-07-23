package com.eurekanetwork.wallet.ui.fragment.contract_management_fragment;

import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.model.contract.ContractMethod;

import java.util.List;

public interface ContractManagementInteractor {
    List<ContractMethod> getContractListByUiid(String uiid);

    List<ContractMethod> getContractListByAbi(String abi);

    Contract getContractByAddress(String contractAddress);
}
