package com.eurekanetwork.wallet.ui.fragment.set_your_token_fragment;

import com.eurekanetwork.wallet.model.contract.ContractMethodParameter;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface SetYourTokenView extends BaseFragmentView {
    void onContractConstructorPrepared(List<ContractMethodParameter> params);
}
