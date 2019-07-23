package com.eurekanetwork.wallet.ui.fragment.contract_management_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.datastorage.FileStorageManager;
import com.eurekanetwork.wallet.datastorage.TinyDB;
import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.model.contract.ContractMethod;

import java.lang.ref.WeakReference;
import java.util.List;

public class ContractManagementInteractorImpl implements ContractManagementInteractor {

    WeakReference<Context> mContext;

    ContractManagementInteractorImpl(Context context) {
        mContext = new WeakReference<Context>(context);
    }

    @Override
    public List<ContractMethod> getContractListByAbi(String abi) {
        return FileStorageManager.getInstance().getContractMethodsByAbiString(mContext.get(), abi);
    }

    @Override
    public Contract getContractByAddress(String address) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        for (Contract contract : tinyDB.getContractList()) {
            if (contract.getContractAddress().equals(address)) {
                return contract;
            }
        }
        return null;
    }

    @Override
    public List<ContractMethod> getContractListByUiid(String uiid) {
        return FileStorageManager.getInstance().getContractMethods(mContext.get(), uiid);
    }
}
