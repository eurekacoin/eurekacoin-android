package com.eurekanetwork.wallet.ui.fragment.backup_wallet_fragment.light;

import com.eurekanetwork.wallet.ui.fragment.backup_wallet_fragment.BackUpWalletFragment;

public class BackUpWalletFragmentLight extends BackUpWalletFragment {
    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_back_up_wallet_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        getMainActivity().recolorStatusBar(com.eurekanetwork.wallet.R.color.title_color_light);
    }
}
