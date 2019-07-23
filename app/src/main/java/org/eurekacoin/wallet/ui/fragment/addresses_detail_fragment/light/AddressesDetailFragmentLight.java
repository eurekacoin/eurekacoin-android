package com.eurekanetwork.wallet.ui.fragment.addresses_detail_fragment.light;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.model.gson.history.TransactionInfo;
import com.eurekanetwork.wallet.model.gson.history.Vin;
import com.eurekanetwork.wallet.model.gson.history.Vout;
import com.eurekanetwork.wallet.ui.fragment.addresses_detail_fragment.AddressesDetailFragment;

import java.util.List;

public class AddressesDetailFragmentLight extends AddressesDetailFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_addresses_detail_light;
    }

    @Override
    public void setUpRecyclerView(List<Vin> transactionFrom, List<Vout> transactionTo, String symbol) {
        mAddressesDetailAdapterTo = new AddressesDetailAdapterLight<>(transactionTo,symbol);
        mAddressesDetailAdapterFrom = new AddressesDetailAdapterLight<>(transactionFrom,symbol);
        mRecyclerViewFrom.setAdapter(mAddressesDetailAdapterFrom);
        mRecyclerViewTo.setAdapter(mAddressesDetailAdapterTo);
    }
}
