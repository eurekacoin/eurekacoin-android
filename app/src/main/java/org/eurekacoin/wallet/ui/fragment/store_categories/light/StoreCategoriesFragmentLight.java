package com.eurekanetwork.wallet.ui.fragment.store_categories.light;

import com.eurekanetwork.wallet.model.gson.QstoreContractType;
import com.eurekanetwork.wallet.ui.fragment.store_categories.StoreCategoriesAdapter;
import com.eurekanetwork.wallet.ui.fragment.store_categories.StoreCategoriesFragment;
import com.eurekanetwork.wallet.ui.fragment.store_categories.StoreCategoryViewHolder;

import java.util.List;

public class StoreCategoriesFragmentLight extends StoreCategoriesFragment {

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.lyt_store_categories_light;
    }

    @Override
    public void setUpCategoriesList(List<QstoreContractType> list, StoreCategoryViewHolder.OnCategoryClickListener listener) {
        adapter = new StoreCategoriesAdapter(list, com.eurekanetwork.wallet.R.layout.lyt_store_category_list_item_light, listener);
        contentList.setAdapter(adapter);
    }
}
