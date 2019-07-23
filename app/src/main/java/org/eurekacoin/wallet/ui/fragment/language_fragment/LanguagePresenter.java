package com.eurekanetwork.wallet.ui.fragment.language_fragment;

import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

public interface LanguagePresenter extends BaseFragmentPresenter {
    String getCurrentLanguage();

    void setCurrentLanguage(String language);
}
