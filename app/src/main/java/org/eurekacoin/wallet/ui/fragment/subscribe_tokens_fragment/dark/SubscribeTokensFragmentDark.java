package com.eurekanetwork.wallet.ui.fragment.subscribe_tokens_fragment.dark;

import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.ui.fragment.subscribe_tokens_fragment.SubscribeTokensFragment;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SubscribeTokensFragmentDark extends SubscribeTokensFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_currency;
    }

    @Override
    public void setTokenList(List<Token> tokenList) {

        Collections.sort(tokenList, new Comparator<Token>() {
            @Override
            public int compare(Token token, Token t1) {
                if (token.isSubscribe() && !t1.isSubscribe()) {
                    return -1;
                } else if (!token.isSubscribe() && t1.isSubscribe()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });

        mTokenAdapter = new TokenAdapter(tokenList, com.eurekanetwork.wallet.R.layout.item_single_checkable);
        mCurrentList = tokenList;
        mRecyclerView.setAdapter(mTokenAdapter);
    }
}