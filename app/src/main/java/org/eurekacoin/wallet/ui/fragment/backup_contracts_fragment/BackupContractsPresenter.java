package com.eurekanetwork.wallet.ui.fragment.backup_contracts_fragment;

import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

interface BackupContractsPresenter extends BaseFragmentPresenter {
    void permissionGrantedForChooseShareMethod();

    void permissionGrantedForCreateAndBackUpFile();

    void permissionGrantedForCreateBackUpFile();

    void onBackUpClick();
}
