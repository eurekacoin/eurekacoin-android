package com.eurekanetwork.wallet.ui.fragment.send_fragment.dark;

import com.eurekanetwork.wallet.model.gson.token_balance.TokenBalance;
import com.eurekanetwork.wallet.ui.fragment.send_fragment.AddressWithTokenBalanceSpinnerAdapter;
import com.eurekanetwork.wallet.ui.fragment.send_fragment.SendFragment;
import com.eurekanetwork.wallet.utils.FontManager;

public class SendFragmentDark extends SendFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_send;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        mTextInputEditTextAddress.setTypeface(FontManager.getInstance().getFont(getString(com.eurekanetwork.wallet.R.string.simplonMonoRegular)));
        mTextInputEditTextAmount.setTypeface(FontManager.getInstance().getFont(getString(com.eurekanetwork.wallet.R.string.simplonMonoRegular)));
        mTextInputEditTextFee.setTypeface(FontManager.getInstance().getFont(getString(com.eurekanetwork.wallet.R.string.simplonMonoRegular)));
        tilAdress.setTypeface(FontManager.getInstance().getFont(getString(com.eurekanetwork.wallet.R.string.simplonMonoRegular)));
        tilAmount.setTypeface(FontManager.getInstance().getFont(getString(com.eurekanetwork.wallet.R.string.simplonMonoRegular)));
        tilFee.setTypeface(FontManager.getInstance().getFont(getString(com.eurekanetwork.wallet.R.string.simplonMonoRegular)));
    }

    @Override
    public void setUpSpinner(TokenBalance tokenBalance, Integer decimalUnits) {
        if(adapter!=null &&
                ((AddressWithTokenBalanceSpinnerAdapter)mSpinner.getAdapter()).getTokenBalance().getContractAddress().equals(tokenBalance.getContractAddress())) {
            adapter.setTokenBalance(tokenBalance);
            adapter.notifyDataSetChanged();
        } else {
            adapter = new AddressWithTokenBalanceSpinnerAdapterDark(getContext(), tokenBalance, "", decimalUnits);
            mSpinner.setAdapter(adapter);
        }
        super.setUpSpinner(tokenBalance, decimalUnits);
    }
}
