package com.eurekanetwork.wallet.ui.fragment.transaction_fragment;

import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

interface TransactionPresenter extends BaseFragmentPresenter {
    void openTransactionView(String txHash, HistoryType historyType);
}
