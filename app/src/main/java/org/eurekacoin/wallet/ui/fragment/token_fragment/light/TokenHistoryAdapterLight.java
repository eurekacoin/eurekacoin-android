package com.eurekanetwork.wallet.ui.fragment.token_fragment.light;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.model.gson.token_history.TokenHistory;
import com.eurekanetwork.wallet.ui.fragment.token_fragment.TokenHistoryAdapter;
import com.eurekanetwork.wallet.ui.fragment.token_fragment.TokenHistoryClickListener;
import com.eurekanetwork.wallet.ui.fragment.wallet_fragment.ProgressBarHolder;

import java.util.List;

public class TokenHistoryAdapterLight extends TokenHistoryAdapter {

    public TokenHistoryAdapterLight(List<TokenHistory> historyList, TokenHistoryClickListener listener, int decimalUnits) {
        super(historyList, listener, decimalUnits);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_TRANSACTION) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_token_transaction_light, parent, false);
            return new TokenHistoryHolderLight(view, listener, decimalUnits);
        } else {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.item_progress_bar, parent, false);
            return new ProgressBarHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProgressBarHolder) {
            ((ProgressBarHolder) holder).bindProgressBar(mLoadingFlag);
        } else {
            mHistory = mHistoryList.get(position);
            ((TokenHistoryHolderLight) holder).bindTransactionData(mHistory, mSymbol);
        }
    }
}
