package com.eurekanetwork.wallet.ui.fragment.other_tokens;

import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface OtherTokensView extends BaseFragmentView {
    void setTokensData(List<Token> tokensData);

    void updateTokensData(List<Token> tokensData);
}
