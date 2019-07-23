package com.eurekanetwork.wallet.ui.fragment.token_cash_management_fragment;

import android.os.Handler;

import com.eurekanetwork.wallet.dataprovider.services.update_service.UpdateService;
import com.eurekanetwork.wallet.model.AddressWithTokenBalance;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface AddressesListTokenView extends BaseFragmentView {
    void updateAddressList(List<AddressWithTokenBalance> deterministicKeyWithBalance, String currency);

    UpdateService getSocketInstance();

    Handler getHandler();

    void hideTransferDialog();

    void goToSendFragment(AddressWithTokenBalance keyWithTokenBalanceFrom, AddressWithTokenBalance keyWithBalanceTo, String amountString, String contractAddress);
}
