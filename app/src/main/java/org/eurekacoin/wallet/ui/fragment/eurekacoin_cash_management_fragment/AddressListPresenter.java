package com.eurekanetwork.wallet.ui.fragment.eurekacoin_cash_management_fragment;

import com.eurekanetwork.wallet.model.AddressWithBalance;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface AddressListPresenter extends BaseFragmentPresenter {
    AddressWithBalance getKeyWithBalanceFrom();

    void setKeyWithBalanceFrom(AddressWithBalance keyWithBalanceFrom);

    List<AddressWithBalance> getAddressWithBalanceList();
}
