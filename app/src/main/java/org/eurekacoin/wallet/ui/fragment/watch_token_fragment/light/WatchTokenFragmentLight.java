package com.eurekanetwork.wallet.ui.fragment.watch_token_fragment.light;

import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment.OnTemplateClickListener;
import com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment.TemplatesAdapter;
import com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import com.eurekanetwork.wallet.ui.fragment.watch_token_fragment.WatchTokenFragment;
import com.eurekanetwork.wallet.utils.FontManager;

import java.util.List;

public class WatchTokenFragmentLight extends WatchTokenFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_watch_token_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(com.eurekanetwork.wallet.R.string.proximaNovaSemibold)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(com.eurekanetwork.wallet.R.string.proximaNovaSemibold)));
    }

}
