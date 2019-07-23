package com.eurekanetwork.wallet.ui.fragment.watch_token_fragment;

import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.model.gson.ContractParams;

import java.util.List;

import rx.Observable;

public interface WatchTokenInteractor {
    List<ContractTemplate> getContractTemplates();

    int compareDates(String date, String date1);

    String readAbiContract(String uuid);

    boolean isValidContractAddress(String address);

    List<Contract> getContracts();

    String handleContractWithToken(String name, String address, String ABIInterface);

    String getERC20TokenStandardAbi();

    Observable<ContractParams> getContractParams(String contractAddress);
}
