package com.eurekanetwork.wallet.ui.fragment.eurekacoin_cash_management_fragment;

import com.eurekanetwork.wallet.model.AddressWithBalance;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface AddressListView extends BaseFragmentView {
    void updateAddressList(List<AddressWithBalance> deterministicKeyWithBalance);
}
