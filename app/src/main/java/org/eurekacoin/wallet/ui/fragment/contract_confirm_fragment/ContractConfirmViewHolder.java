package com.eurekanetwork.wallet.ui.fragment.contract_confirm_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.eurekanetwork.wallet.model.contract.ContractMethodParameter;
import com.eurekanetwork.wallet.utils.FontTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContractConfirmViewHolder extends RecyclerView.ViewHolder {

    @BindView(com.eurekanetwork.wallet.R.id.name)
    FontTextView name;

    @BindView(com.eurekanetwork.wallet.R.id.value)
    FontTextView value;

    @BindView(com.eurekanetwork.wallet.R.id.root_layout)
    RelativeLayout rootLayout;

    public ContractConfirmViewHolder(View itemView, final OnValueClick clickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        rootLayout.setClickable(true);

        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(getAdapterPosition());
            }
        });
    }

    public void bind(ContractMethodParameter parameter) {
        name.setText(parameter.getDisplayName());
        value.setText(parameter.getValue());
    }
}
