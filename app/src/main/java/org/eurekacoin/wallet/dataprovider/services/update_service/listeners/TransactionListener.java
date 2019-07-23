package com.eurekanetwork.wallet.dataprovider.services.update_service.listeners;

import com.eurekanetwork.wallet.model.gson.history.History;

public interface TransactionListener {
    void onNewHistory(History history);

    boolean getVisibility();
}
