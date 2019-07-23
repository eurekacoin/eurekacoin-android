package com.eurekanetwork.wallet.ui.fragment.subscribe_tokens_fragment;

import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface AddressesListTokenPresenter extends BaseFragmentPresenter {
    void onSubscribeChanged(Token token);
}
