package com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment;

import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragment;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface WatchContractView extends BaseFragmentView {
    void setABIInterface(String name, String abiInterface);

    void setUpTemplatesList(List<ContractTemplate> contractTemplateList, OnTemplateClickListener listener);

    void notifyAdapter(int adapterPosition);

    OnTemplateClickListener getTemplateClickListener();

    BaseFragment.AlertDialogCallBack getAlertCallback();
}
