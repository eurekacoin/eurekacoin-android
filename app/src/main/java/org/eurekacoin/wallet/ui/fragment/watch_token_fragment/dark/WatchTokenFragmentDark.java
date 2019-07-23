package com.eurekanetwork.wallet.ui.fragment.watch_token_fragment.dark;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment.OnTemplateClickListener;
import com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment.TemplatesAdapter;
import com.eurekanetwork.wallet.ui.fragment.watch_contract_fragment.WatchContractFragment;
import com.eurekanetwork.wallet.ui.fragment.watch_token_fragment.WatchTokenFragment;
import com.eurekanetwork.wallet.utils.FontManager;

import java.util.List;

public class WatchTokenFragmentDark extends WatchTokenFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_watch_token;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mEditTextContractName.setTypeface(FontManager.getInstance().getFont(getResources().getString(R.string.simplonMonoMedium)));
        mEditTextContractAddress.setTypeface(FontManager.getInstance().getFont(getResources().getString(R.string.simplonMonoMedium)));
    }

}
