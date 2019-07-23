package com.eurekanetwork.wallet.ui.fragment.currency_fragment.light;

import com.eurekanetwork.wallet.model.Currency;
import com.eurekanetwork.wallet.ui.fragment.currency_fragment.CurrencyFragment;

import java.util.List;

public class CurrencyFragmentLight extends CurrencyFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_currency_light;
    }

    @Override
    public void setCurrencyList(List<Currency> currencyList) {
        mCurrencyAdapter = new CurrencyAdapter(currencyList, com.eurekanetwork.wallet.R.layout.lyt_token_list_item_light);
        mCurrentList = currencyList;
        mRecyclerView.setAdapter(mCurrencyAdapter);
    }
}
