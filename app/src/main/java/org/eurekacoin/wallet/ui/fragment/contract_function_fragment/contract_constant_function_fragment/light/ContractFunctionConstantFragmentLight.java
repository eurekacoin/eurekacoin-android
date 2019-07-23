package com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.contract_constant_function_fragment.light;

import com.eurekanetwork.wallet.model.contract.ContractMethodParameter;
import com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.ParameterAdapter;
import com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.contract_constant_function_fragment.ContractFunctionConstantFragment;

import java.util.List;

public class ContractFunctionConstantFragmentLight extends ContractFunctionConstantFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_function_constant_detail_light;
    }

    @Override
    public void setUpParameterList(List<ContractMethodParameter> contractMethodParameterList) {
        mParameterAdapter = new ParameterAdapter(contractMethodParameterList, com.eurekanetwork.wallet.R.layout.lyt_constructor_input_light);
        mParameterList.setAdapter(mParameterAdapter);
    }
}
