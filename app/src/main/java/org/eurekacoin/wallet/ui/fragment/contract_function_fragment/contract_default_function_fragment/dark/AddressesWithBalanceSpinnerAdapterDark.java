package com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.dark;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.model.AddressWithBalance;
import com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment.AddressesWithBalanceSpinnerAdapter;

import java.util.List;

public class AddressesWithBalanceSpinnerAdapterDark extends AddressesWithBalanceSpinnerAdapter {

    public AddressesWithBalanceSpinnerAdapterDark(@NonNull Context context, List<AddressWithBalance> keyWithBalanceList) {
        super(context, keyWithBalanceList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomView(position, R.layout.item_address_spinner_send, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getCustomDropDownView(position, R.layout.item_address_spinner_dropdown_send, parent);
    }
}
