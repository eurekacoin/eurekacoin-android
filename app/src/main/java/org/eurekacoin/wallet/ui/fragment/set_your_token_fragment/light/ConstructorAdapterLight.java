package com.eurekanetwork.wallet.ui.fragment.set_your_token_fragment.light;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eurekanetwork.wallet.model.contract.ContractMethodParameter;
import com.eurekanetwork.wallet.ui.fragment.set_your_token_fragment.ConstructorAdapter;
import com.eurekanetwork.wallet.ui.fragment.set_your_token_fragment.InputViewHolder;
import com.eurekanetwork.wallet.ui.fragment.set_your_token_fragment.OnValidateParamsListener;

import java.util.List;

public class ConstructorAdapterLight extends ConstructorAdapter {

    public ConstructorAdapterLight(List<ContractMethodParameter> params, OnValidateParamsListener listener) {
        super(params, listener);
    }

    @Override
    public InputViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new InputViewHolderLight(LayoutInflater.from(parent.getContext()).inflate(com.eurekanetwork.wallet.R.layout.lyt_constructor_input_light, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(InputViewHolder holder, int position) {
        holder.bind(params.get(position),position == getItemCount()-1);
    }
}
