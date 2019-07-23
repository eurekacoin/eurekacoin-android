package com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment.light;

import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment.OnTemplateClickListener;
import com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment.TemplatesAdapter;
import com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import com.eurekanetwork.wallet.utils.FontManager;

import java.util.List;

public class WatchContractFragmentLight extends WatchContractFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_watch_contract_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(com.eurekanetwork.wallet.R.string.proximaNovaSemibold)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(com.eurekanetwork.wallet.R.string.proximaNovaSemibold)));
    }

    @Override
    public void setUpTemplatesList(List<ContractTemplate> contractTemplateList, OnTemplateClickListener listener) {
        mRecyclerViewTemplates.setAdapter(new TemplatesAdapter(contractTemplateList, listener, com.eurekanetwork.wallet.R.layout.item_template_chips_light, com.eurekanetwork.wallet.R.drawable.chip_selected_corner_background));
    }
}
