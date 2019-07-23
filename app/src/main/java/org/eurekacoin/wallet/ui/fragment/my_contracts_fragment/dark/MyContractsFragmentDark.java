package com.eurekanetwork.wallet.ui.fragment.my_contracts_fragment.dark;

import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.ui.fragment.my_contracts_fragment.ContractItemListener;
import com.eurekanetwork.wallet.ui.fragment.my_contracts_fragment.MyContractsFragment;

import java.util.List;

public class MyContractsFragmentDark extends MyContractsFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_my_contracts;
    }


    @Override
    public void setUpRecyclerView(List<Contract> contractList, ContractItemListener contractItemListener) {
        mContractAdapter = new ContractAdapter(contractList, com.eurekanetwork.wallet.R.layout.item_contract_list, contractItemListener);
        mRecyclerView.setAdapter(mContractAdapter);
    }
}
