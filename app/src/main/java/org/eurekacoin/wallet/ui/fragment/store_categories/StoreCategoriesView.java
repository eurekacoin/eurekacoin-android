package com.eurekanetwork.wallet.ui.fragment.store_categories;

import com.eurekanetwork.wallet.model.gson.QstoreContractType;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

import java.util.List;

public interface StoreCategoriesView extends BaseFragmentView {
    void setUpCategoriesList(List<QstoreContractType> list, StoreCategoryViewHolder.OnCategoryClickListener listener);
}
