package com.eurekanetwork.wallet.utils;

import org.bitcoinj.core.NetworkParameters;
import org.bitcoinj.params.EurekacoinMainNetParams;
import org.bitcoinj.params.EurekacoinTestNetParams;
import com.eurekanetwork.wallet.BuildConfig;

public class CurrentNetParams {

    public  CurrentNetParams(){}

    public static NetworkParameters getNetParams(){
        return BuildConfig.USE_MAIN_NET? EurekacoinMainNetParams.get() : EurekacoinTestNetParams.get();
    }

    public static String getUrl(){
        return BuildConfig.API_URL;
    }
}
