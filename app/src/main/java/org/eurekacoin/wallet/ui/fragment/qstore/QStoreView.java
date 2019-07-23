package com.eurekanetwork.wallet.ui.fragment.qstore;

import com.eurekanetwork.wallet.model.gson.qstore.QSearchItem;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;
import com.eurekanetwork.wallet.ui.fragment.qstore.categories.QstoreCategory;

import java.util.List;

public interface QStoreView extends BaseFragmentView {
    void setCategories(List<QstoreCategory> categories);

    void setSearchResult(List<QSearchItem> items);

    void setSearchBarText(String text);

    String getSeacrhBarText();
}
