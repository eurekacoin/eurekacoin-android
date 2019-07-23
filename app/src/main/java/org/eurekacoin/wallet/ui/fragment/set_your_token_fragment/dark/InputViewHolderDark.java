package com.eurekanetwork.wallet.ui.fragment.set_your_token_fragment.dark;

import android.view.View;

import com.eurekanetwork.wallet.ui.fragment.set_your_token_fragment.InputViewHolder;
import com.eurekanetwork.wallet.ui.fragment.set_your_token_fragment.OnValidateParamsListener;
import com.eurekanetwork.wallet.utils.FontManager;

public class InputViewHolderDark extends InputViewHolder {

    public InputViewHolderDark(View itemView, OnValidateParamsListener listener) {
        super(itemView, listener);
        tilParam.setTypeface(FontManager.getInstance().getFont(tilParam.getContext().getString(com.eurekanetwork.wallet.R.string.simplonMonoRegular)));
        etParam.setTypeface(FontManager.getInstance().getFont(etParam.getContext().getString(com.eurekanetwork.wallet.R.string.simplonMonoRegular)));
    }
}
