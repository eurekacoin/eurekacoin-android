package com.eurekanetwork.wallet.ui.fragment.templates_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.datastorage.TinyDB;
import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.utils.DateCalculator;

import java.lang.ref.WeakReference;
import java.util.List;

public class TemplatesInteractorImpl implements TemplatesInteractor {

    private WeakReference<Context> mContext;

    public TemplatesInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public List<ContractTemplate> getContractTemplates() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getContractTemplateList();
    }

    @Override
    public int compareDates(String date, String date1) {
        return DateCalculator.equals(date, date1);
    }
}
