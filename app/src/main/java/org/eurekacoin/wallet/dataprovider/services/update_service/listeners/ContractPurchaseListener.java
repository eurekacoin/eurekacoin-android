package com.eurekanetwork.wallet.dataprovider.services.update_service.listeners;

import com.eurekanetwork.wallet.model.gson.qstore.ContractPurchase;

public interface ContractPurchaseListener {
    void onContractPurchased(ContractPurchase purchaseData);
}
