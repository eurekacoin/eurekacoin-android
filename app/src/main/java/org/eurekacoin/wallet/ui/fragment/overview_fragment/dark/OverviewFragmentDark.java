package com.eurekanetwork.wallet.ui.fragment.overview_fragment.dark;


import android.util.Pair;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.ui.fragment.overview_fragment.CopyableOverviewItem;
import com.eurekanetwork.wallet.ui.fragment.overview_fragment.OverviewFragment;

import java.util.List;

public class OverviewFragmentDark extends OverviewFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_overview;
    }

    @Override
    public void setUpOverview(List<CopyableOverviewItem> overview) {
        mOverviewAdapter = new OverviewAdapter(overview, R.layout.item_overview);
        mRecyclerViewOverview.setAdapter(mOverviewAdapter);
    }

}
