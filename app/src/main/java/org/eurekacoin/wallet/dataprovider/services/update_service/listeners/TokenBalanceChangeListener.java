package com.eurekanetwork.wallet.dataprovider.services.update_service.listeners;

import com.eurekanetwork.wallet.model.gson.token_balance.TokenBalance;

public interface TokenBalanceChangeListener {
    void onBalanceChange(TokenBalance tokenBalance);
}
