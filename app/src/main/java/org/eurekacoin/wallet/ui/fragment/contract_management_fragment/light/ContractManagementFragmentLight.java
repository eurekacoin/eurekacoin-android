package com.eurekanetwork.wallet.ui.fragment.contract_management_fragment.light;

import com.eurekanetwork.wallet.model.contract.ContractMethod;
import com.eurekanetwork.wallet.ui.fragment.contract_management_fragment.ContractManagementFragment;

import java.util.List;

public class ContractManagementFragmentLight extends ContractManagementFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_contract_management_light;
    }

    @Override
    public void setRecyclerView(List<ContractMethod> contractMethodList, boolean needToGetValue) {
        mMethodAdapter = new MethodAdapter(contractMethodList, com.eurekanetwork.wallet.R.layout.item_contract_property_light, com.eurekanetwork.wallet.R.layout.item_contract_method_light, needToGetValue);
        mRecyclerView.setAdapter(mMethodAdapter);
    }
}

