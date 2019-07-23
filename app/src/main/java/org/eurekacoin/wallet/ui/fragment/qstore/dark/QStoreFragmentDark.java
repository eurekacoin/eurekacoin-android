package com.eurekanetwork.wallet.ui.fragment.qstore.dark;

import com.eurekanetwork.wallet.model.gson.qstore.QSearchItem;
import com.eurekanetwork.wallet.ui.fragment.qstore.QStoreFragment;
import com.eurekanetwork.wallet.ui.fragment.qstore.StoreAdapter;
import com.eurekanetwork.wallet.ui.fragment.qstore.StoreSearchAdapter;
import com.eurekanetwork.wallet.ui.fragment.qstore.categories.QstoreCategory;

import java.util.List;

public class QStoreFragmentDark extends QStoreFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.lyt_q_store;
    }

    @Override
    public void setCategories(List<QstoreCategory> categories) {
        storeAdapter = new StoreAdapter(categories, this, com.eurekanetwork.wallet.R.layout.lyt_store_list_item, com.eurekanetwork.wallet.R.layout.lyt_store_token_list_item);
        contentList.setAdapter(storeAdapter);
    }

    @Override
    public void setSearchResult(List<QSearchItem> items) {
        searchAdapter = new StoreSearchAdapter(items, this, com.eurekanetwork.wallet.R.layout.lyt_store_search_list_item);
        contentList.setAdapter(searchAdapter);
    }
}
