package com.eurekanetwork.wallet.ui.fragment.backup_wallet_fragment;

import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

interface BackUpWalletPresenter extends BaseFragmentPresenter {
    void onCopyBrainCodeClick();

    void onContinueClick();

    void onShareClick();
}
