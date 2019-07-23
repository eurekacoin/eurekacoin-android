package com.eurekanetwork.wallet.ui.fragment.qstore_by_type.dark;

import com.eurekanetwork.wallet.model.gson.qstore.QSearchItem;
import com.eurekanetwork.wallet.ui.fragment.qstore_by_type.QStoreByTypeFragment;
import com.eurekanetwork.wallet.ui.fragment.qstore_by_type.StoreSearchAdapter;

import java.util.List;

public class QStoreByTypeFragmentDark extends QStoreByTypeFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.lyt_q_store;
    }

    @Override
    public void setSearchResult(List<QSearchItem> items) {
        searchAdapter = new StoreSearchAdapter(items, this, com.eurekanetwork.wallet.R.layout.lyt_store_search_list_item);
        contentList.setAdapter(searchAdapter);
    }
}
