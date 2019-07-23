package com.eurekanetwork.wallet.ui.fragment.template_library_fragment.dark;

import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.ui.fragment.template_library_fragment.TemplateLibraryFragment;

import java.util.List;

public class TemplateLibraryFragmentDark extends TemplateLibraryFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_template_library;
    }

    @Override
    public void setUpTemplateList(List<ContractTemplate> contractTemplateList) {
        initializeRecyclerView(contractTemplateList, com.eurekanetwork.wallet.R.layout.item_template);
    }
}
