package com.eurekanetwork.wallet.ui.fragment.contract_confirm_fragment;

import com.eurekanetwork.wallet.EurekacoinApplication;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

public interface ContractConfirmView extends BaseFragmentView {

    void makeToast(String s);

    EurekacoinApplication getApplication();

    String getContractName();

    void updateFee(double minFee, double maxFee);

    void updateGasPrice(int minGasPrice, int maxGasPrice);

    void updateGasLimit(int minGasLimit, int maxGasLimit);

    void closeFragments();
}
