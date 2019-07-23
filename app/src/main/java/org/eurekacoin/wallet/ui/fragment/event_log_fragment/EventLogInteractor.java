package com.eurekanetwork.wallet.ui.fragment.event_log_fragment;


import com.eurekanetwork.wallet.model.gson.history.History;

public interface EventLogInteractor {
    History getHistory(String txHash);
}
