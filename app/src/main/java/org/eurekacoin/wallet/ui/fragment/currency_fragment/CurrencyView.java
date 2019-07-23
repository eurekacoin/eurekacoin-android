package com.eurekanetwork.wallet.ui.fragment.currency_fragment;

import com.eurekanetwork.wallet.model.Currency;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface CurrencyView extends BaseFragmentView {
    void setCurrencyList(List<Currency> currencyList);
}
