package com.eurekanetwork.wallet.ui.fragment.start_page_fragment.light;

import android.view.View;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.ui.fragment.start_page_fragment.StartPageFragment;
import com.eurekanetwork.wallet.ui.wave_visualizer.WaveHelper;
import com.eurekanetwork.wallet.ui.wave_visualizer.WaveView;

import butterknife.BindView;

public class StartPageFragmentLight extends StartPageFragment {

    @BindView(R.id.wave_view)
    WaveView waveView;
    private WaveHelper mWaveHelper;

    @Override
    protected int getLayout() {
        return R.layout.fragment_start_page_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        waveView.setShapeType(WaveView.ShapeType.SQUARE);
        mWaveHelper = new WaveHelper(waveView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mWaveHelper.start();
    }

    @Override
    public void onPause() {
        mWaveHelper.cancel();
        super.onPause();
    }

    @Override
    public void hideLoginButton() {
        mButtonLogin.setVisibility(View.GONE);
    }
}
