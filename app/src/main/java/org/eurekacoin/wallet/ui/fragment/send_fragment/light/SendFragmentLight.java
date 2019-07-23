package com.eurekanetwork.wallet.ui.fragment.send_fragment.light;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.model.gson.token_balance.TokenBalance;
import com.eurekanetwork.wallet.ui.activity.main_activity.MainActivity;
import com.eurekanetwork.wallet.ui.fragment.send_fragment.AddressWithTokenBalanceSpinnerAdapter;
import com.eurekanetwork.wallet.ui.fragment.send_fragment.SendFragment;
import com.eurekanetwork.wallet.utils.FontManager;

public class SendFragmentLight extends SendFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_send_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        ((MainActivity) getActivity()).showBottomNavigationView(R.color.title_color_light);
        mTextInputEditTextAddress.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaSemibold)));
        mTextInputEditTextAmount.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaSemibold)));
        mTextInputEditTextFee.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaSemibold)));
        tilAdress.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaRegular)));
        tilAmount.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaRegular)));
        tilFee.setTypeface(FontManager.getInstance().getFont(getString(R.string.proximaNovaRegular)));
    }

    @Override
    public void setUpSpinner(TokenBalance tokenBalance, Integer decimalUnits) {
        if(adapter!=null &&
                ((AddressWithTokenBalanceSpinnerAdapter)mSpinner.getAdapter()).getTokenBalance().getContractAddress().equals(tokenBalance.getContractAddress())) {
            adapter.setTokenBalance(tokenBalance);
            adapter.notifyDataSetChanged();
        } else {
            adapter = new AddressWithTokenBalanceSpinnerAdapterLight(getContext(), tokenBalance, "", decimalUnits);
            mSpinner.setAdapter(adapter);
        }
        super.setUpSpinner(tokenBalance, decimalUnits);
    }
}
