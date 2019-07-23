package com.eurekanetwork.wallet.ui.fragment.profile_fragment;

import com.eurekanetwork.wallet.datastorage.listeners.LanguageChangeListener;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface ProfilePresenter extends BaseFragmentPresenter {
    void onTouchIdSwitched(boolean isChecked);

    void clearWallet();

    List<SettingObject> getSettingsData();

    void setupLanguageChangeListener(LanguageChangeListener listener);

    void removeLanguageListener(LanguageChangeListener listener);
}
