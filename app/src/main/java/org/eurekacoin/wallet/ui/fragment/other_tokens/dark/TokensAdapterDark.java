package com.eurekanetwork.wallet.ui.fragment.other_tokens.dark;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.ui.fragment.other_tokens.OnTokenClickListener;
import com.eurekanetwork.wallet.ui.fragment.other_tokens.TokenViewHolder;
import com.eurekanetwork.wallet.ui.fragment.other_tokens.TokensAdapter;
import com.eurekanetwork.wallet.ui.fragment.other_tokens.UpdateSocketInstance;

import java.util.List;

public class TokensAdapterDark extends TokensAdapter {

    public TokensAdapterDark(List<Token> tokens, UpdateSocketInstance socketInstance, OnTokenClickListener listener) {
        super(tokens, socketInstance, listener);
    }

    @Override
    public TokenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TokenViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lyt_token_list_item, parent, false), socketInstace, parent.getContext(), listener);
    }

    @Override
    public void onBindViewHolder(TokenViewHolder holder, int position) {
        holder.bind(tokens.get(position));
    }
}
