package com.eurekanetwork.wallet.ui.fragment.other_tokens.light;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragment;
import com.eurekanetwork.wallet.ui.fragment.other_tokens.OtherTokensFragment;
import com.eurekanetwork.wallet.ui.fragment.token_fragment.TokenFragment;

import java.util.List;

public class OtherTokensFragmentLight extends OtherTokensFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.lyt_other_tokens_light;
    }

    @Override
    public void setTokensData(List<Token> tokensData) {
        tokensList.setAdapter(new TokensAdapterLight(tokensData, this, this));
    }

    @Override
    public void onTokenClick(int adapterPosition) {
        if (tokensList.getAdapter() != null) {
            Token token = (Token)((TokensAdapterLight) tokensList.getAdapter()).get(adapterPosition);
            if(token.getSupportFlag()) {
                BaseFragment tokenFragment = TokenFragment.newInstance(getContext(), token);
                openFragment(tokenFragment);
            } else {
                setAlertDialog(getString(R.string.token_unsupported_reason),getString(R.string.ok),PopUpType.error);
            }
        }
    }
}
