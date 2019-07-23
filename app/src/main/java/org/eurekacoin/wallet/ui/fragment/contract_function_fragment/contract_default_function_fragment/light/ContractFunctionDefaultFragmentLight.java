package com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.light;

import com.eurekanetwork.wallet.model.AddressWithBalance;
import com.eurekanetwork.wallet.model.contract.ContractMethodParameter;
import com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.ParameterAdapter;
import com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.AddressesWithBalanceSpinnerAdapter;
import com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.ContractFunctionDefaultFragment;

import java.util.List;

public class ContractFunctionDefaultFragmentLight extends ContractFunctionDefaultFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_function_detail_light;
    }

    @Override
    public void setUpParameterList(List<ContractMethodParameter> contractMethodParameterList) {
        mParameterAdapter = new ParameterAdapter(contractMethodParameterList, com.eurekanetwork.wallet.R.layout.lyt_constructor_input_light);
        mParameterList.setAdapter(mParameterAdapter);
    }

    @Override
    public void updateAddressWithBalanceSpinner(List<AddressWithBalance> addressWithBalances) {
        AddressesWithBalanceSpinnerAdapter adapter = new AddressesWithBalanceSpinnerAdapterLight(getContext(), addressWithBalances);
        mSpinner.setAdapter(adapter);
    }
}
