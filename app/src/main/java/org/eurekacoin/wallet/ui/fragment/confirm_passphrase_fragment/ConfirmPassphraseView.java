package com.eurekanetwork.wallet.ui.fragment.confirm_passphrase_fragment;

import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;


public interface ConfirmPassphraseView extends BaseFragmentView{
    String getSeed();
    void setUpRecyclerViews(List<String> seed);
    void resetAll(List<String> seed);
    void showError();
    void hideError();
    void onLogin();
}
