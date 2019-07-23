package com.eurekanetwork.wallet.ui.fragment.language_fragment;

import android.util.Pair;

import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface LanguageView extends BaseFragmentView {
    void setUpLanguagesList(List<Pair<String, String>> languagesList);

    void resetText();
}