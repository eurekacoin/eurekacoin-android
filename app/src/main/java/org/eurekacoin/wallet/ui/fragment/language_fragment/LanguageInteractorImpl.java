package com.eurekanetwork.wallet.ui.fragment.language_fragment;

import android.content.Context;
import android.util.Pair;

import com.eurekanetwork.wallet.datastorage.EurekacoinSettingSharedPreference;
import com.eurekanetwork.wallet.datastorage.EurekacoinSharedPreference;
import com.eurekanetwork.wallet.datastorage.listeners.LanguageChangeListener;

import java.util.ArrayList;
import java.util.List;

class LanguageInteractorImpl implements LanguageInteractor {

    private Context mContext;
    private List<Pair<String, String>> mLanguagesList;

    LanguageInteractorImpl(Context context) {
        mContext = context;
        mLanguagesList = new ArrayList<>();
        mLanguagesList.add(new Pair<>("us", "English"));
        mLanguagesList.add(new Pair<>("zh", "Chinese"));
    }

    @Override
    public String getLanguage() {
        return EurekacoinSettingSharedPreference.getInstance().getLanguage(mContext);
    }

    @Override
    public void setLanguage(String language) {
        EurekacoinSettingSharedPreference.getInstance().saveLanguage(mContext, language);
    }

    @Override
    public List<Pair<String, String>> getLanguagesList() {
        return mLanguagesList;
    }

    @Override
    public void removeLanguageListener(LanguageChangeListener languageChangeListener) {
        EurekacoinSettingSharedPreference.getInstance().removeLanguageListener(languageChangeListener);
    }

    @Override
    public void addLanguageListener(LanguageChangeListener languageChangeListener) {
        EurekacoinSettingSharedPreference.getInstance().addLanguageListener(languageChangeListener);
    }
}