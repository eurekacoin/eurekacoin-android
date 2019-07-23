package com.eurekanetwork.wallet.ui.fragment.about_fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.eurekanetwork.wallet.model.Version;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragment;
import com.eurekanetwork.wallet.ui.fragment_factory.Factory;
import com.eurekanetwork.wallet.utils.FontTextView;

import butterknife.BindView;
import butterknife.OnClick;

public abstract class AboutFragment extends BaseFragment implements AboutView {

    AboutPresenter mAboutFragmentPresenter;

    @OnClick({com.eurekanetwork.wallet.R.id.ibt_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case com.eurekanetwork.wallet.R.id.ibt_back:
                getActivity().onBackPressed();
                break;
        }
    }

    @BindView(com.eurekanetwork.wallet.R.id.tv_eurekacoin_version)
    FontTextView mTextViewEurekacoinVersion;

    public static BaseFragment newInstance(Context context) {
        Bundle args = new Bundle();
        BaseFragment fragment = Factory.instantiateFragment(context, AboutFragment.class);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void updateVersion(Version version) {
        String footer = getString(com.eurekanetwork.wallet.R.string._2017_eurekacoin_n_skynet_testnet_version) + "Version " + version.getVersionName() + "(" + String.valueOf(version.getVersionCode()) + ")";
        mTextViewEurekacoinVersion.setText(footer);
    }

    @Override
    protected void createPresenter() {
        mAboutFragmentPresenter = new AboutPresenterImpl(this, new AboutInteractorImpl(getContext()));
    }

    @Override
    protected AboutPresenter getPresenter() {
        return mAboutFragmentPresenter;
    }
}