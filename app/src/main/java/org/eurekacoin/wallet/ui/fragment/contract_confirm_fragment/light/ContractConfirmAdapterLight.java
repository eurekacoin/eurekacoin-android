package com.eurekanetwork.wallet.ui.fragment.contract_confirm_fragment.light;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eurekanetwork.wallet.R;
import com.eurekanetwork.wallet.model.contract.ContractMethodParameter;
import com.eurekanetwork.wallet.ui.fragment.contract_confirm_fragment.ContractConfirmAdapter;
import com.eurekanetwork.wallet.ui.fragment.contract_confirm_fragment.ContractConfirmFooterViewHolder;
import com.eurekanetwork.wallet.ui.fragment.contract_confirm_fragment.ContractConfirmViewHolder;
import com.eurekanetwork.wallet.ui.fragment.contract_confirm_fragment.OnValueClick;

import java.util.List;

public class ContractConfirmAdapterLight extends ContractConfirmAdapter {
    ContractConfirmAdapterLight(List<ContractMethodParameter> params, String mineAddress, OnValueClick clickListener) {
        super(params, mineAddress, clickListener);
    }

    @Override
    protected RecyclerView.ViewHolder getItemView(LayoutInflater inflater, ViewGroup parent) {
        return new ContractConfirmViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lyt_confirm_list_item_light, parent, false), clickListener);
    }

    @Override
    protected RecyclerView.ViewHolder getFooterView(LayoutInflater inflater, ViewGroup parent) {
        return new ContractConfirmFooterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.lyt_confirm_list_footer_light, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ContractConfirmViewHolder) {
            ((ContractConfirmViewHolder) holder).bind(getItem(position));
        } else if (holder instanceof ContractConfirmFooterViewHolder) {
            ((ContractConfirmFooterViewHolder) holder).bind(mineAddress);
        }
    }
}
