package com.eurekanetwork.wallet.ui.fragment.templates_fragment;

import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface TemplatesView extends BaseFragmentView {
    void setUpTemplateList(List<ContractTemplate> contractTemplateList);
}
