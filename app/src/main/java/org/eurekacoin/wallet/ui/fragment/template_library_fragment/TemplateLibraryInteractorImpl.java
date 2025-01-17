package com.eurekanetwork.wallet.ui.fragment.template_library_fragment;

import android.content.Context;

import com.eurekanetwork.wallet.datastorage.TinyDB;
import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.utils.DateCalculator;

import java.lang.ref.WeakReference;
import java.util.List;

public class TemplateLibraryInteractorImpl implements TemplateLibraryInteractor {

    private WeakReference<Context> mContext;

    public TemplateLibraryInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public List<ContractTemplate> getContactTemplates() {
        TinyDB tinyDB = new TinyDB(mContext.get());
        return tinyDB.getContractTemplateList();
    }

    @Override
    public int compareDates(String date, String date1) {
        return DateCalculator.equals(date, date1);
    }
}
