package com.eurekanetwork.wallet.ui.fragment.smart_contracts_fragment.light;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.ui.fragment.profile_fragment.SettingObject;
import com.eurekanetwork.wallet.ui.fragment.smart_contracts_fragment.SmartContractsFragment;

import java.util.ArrayList;
import java.util.List;

public class SmartContractsFragmentLight extends SmartContractsFragment {

    private List<SettingObject> settingsData;

    @Override
    protected int getLayout() {
        return com.eurekanetwork.wallet.R.layout.fragment_smart_contracts_light;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        settingsData = new ArrayList<>();
        settingsData.add(new SettingObject(com.eurekanetwork.wallet.R.string.my_new_contracts, com.eurekanetwork.wallet.R.drawable.ic_my_new_contracts_light, 0));
        settingsData.add(new SettingObject(com.eurekanetwork.wallet.R.string.my_published_contracts, com.eurekanetwork.wallet.R.drawable.ic_my_published_contracts_light, 0));
        //settingsData.add(new SettingObject(R.string.contracts_store, R.drawable.eurekacoin_logo, 0));
        settingsData.add(new SettingObject(com.eurekanetwork.wallet.R.string.watch_contract, com.eurekanetwork.wallet.R.drawable.ic_contr_watch_light, 0));
        settingsData.add(new SettingObject(com.eurekanetwork.wallet.R.string.watch_token, com.eurekanetwork.wallet.R.drawable.ic_token_watch_light, 0));
        settingsData.add(new SettingObject(com.eurekanetwork.wallet.R.string.backup_contracts, com.eurekanetwork.wallet.R.drawable.ic_contract_backup_light, 0));
        settingsData.add(new SettingObject(com.eurekanetwork.wallet.R.string.restore_contracts, com.eurekanetwork.wallet.R.drawable.ic_contract_restore_light, 0));
        initializeList(com.eurekanetwork.wallet.R.layout.lyt_profile_pref_list_item_light, com.eurekanetwork.wallet.R.drawable.color_primary_divider_light, com.eurekanetwork.wallet.R.drawable.section_setting_divider_light, settingsData);
    }
}
