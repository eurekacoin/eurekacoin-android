package com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment;

import com.eurekanetwork.wallet.model.ContractTemplate;

public interface OnTemplateClickListener {
    void updateSelection(int adapterPosition);

    void onTemplateClick(ContractTemplate contractTemplate);
}
