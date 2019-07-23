package com.eurekanetwork.wallet.ui.fragment.subscribe_tokens_fragment;

import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface SubscribeTokensView extends BaseFragmentView {

    void setTokenList(List<Token> tokenList);

    void setPlaceHolder();
}
