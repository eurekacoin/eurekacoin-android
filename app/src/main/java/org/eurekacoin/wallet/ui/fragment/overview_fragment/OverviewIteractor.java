package com.eurekanetwork.wallet.ui.fragment.overview_fragment;


import com.eurekanetwork.wallet.model.gson.history.History;
import com.eurekanetwork.wallet.model.gson.history.TransactionReceipt;
import com.eurekanetwork.wallet.model.gson.token_history.TokenHistory;

public interface OverviewIteractor {
    History getHistory(String txHash);
    TokenHistory getTokenHistory(String txHash);
    TransactionReceipt getReceiptByRxhHashFromRealm(String txHash);
}
