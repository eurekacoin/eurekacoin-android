package com.eurekanetwork.wallet.ui.fragment.overview_fragment.light;


import android.util.Pair;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.ui.fragment.overview_fragment.CopyableOverviewItem;
import com.eurekanetwork.wallet.ui.fragment.overview_fragment.OverviewFragment;

import java.util.List;

public class OverviewFragmentLight extends OverviewFragment {

    @Override
    protected int getLayout() {
        return R.layout.fragment_overview_light;
    }

    @Override
    public void setUpOverview(List<CopyableOverviewItem> overview) {
        mOverviewAdapter = new OverviewAdapter(overview, R.layout.item_overview_light);
        mRecyclerViewOverview.setAdapter(mOverviewAdapter);
    }

}
