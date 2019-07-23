package com.eurekanetwork.wallet.ui.fragment.templates_fragment.dark;

import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.ui.fragment.templates_fragment.TemplatesFragment;

import java.util.List;

public class TemplatesFragmentDark extends TemplatesFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_templates;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, com.eurekanetwork.wallet.R.layout.item_template);
    }
}
