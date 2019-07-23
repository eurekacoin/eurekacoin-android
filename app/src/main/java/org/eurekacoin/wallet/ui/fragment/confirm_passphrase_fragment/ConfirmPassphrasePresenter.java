package com.eurekanetwork.wallet.ui.fragment.confirm_passphrase_fragment;

import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;


public interface ConfirmPassphrasePresenter extends BaseFragmentPresenter{
    void onResetAllClick();
    void seedEntered(List<String> seed);
}
