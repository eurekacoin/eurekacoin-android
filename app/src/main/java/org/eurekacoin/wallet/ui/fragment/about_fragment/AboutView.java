package com.eurekanetwork.wallet.ui.fragment.about_fragment;

import com.eurekanetwork.wallet.model.Version;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentView;

public interface AboutView extends BaseFragmentView {
    void updateVersion(Version version);
}
