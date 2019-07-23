package com.eurekanetwork.wallet.ui.fragment.templates_fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.utils.DateCalculator;
import com.eurekanetwork.wallet.utils.FontTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TemplateViewHolder extends RecyclerView.ViewHolder {

    @BindView(com.eurekanetwork.wallet.R.id.title)
    FontTextView title;

    @BindView(com.eurekanetwork.wallet.R.id.date)
    FontTextView date;

    @BindView(com.eurekanetwork.wallet.R.id.contract_type)
    FontTextView contractType;

    @BindView(com.eurekanetwork.wallet.R.id.root_layout)
    RelativeLayout rootLayout;

    private ContractTemplate mContractTemplate;

    public TemplateViewHolder(View itemView, final TemplateSelectListener listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSelectContract(mContractTemplate);
            }
        });
    }

    public void bind(ContractTemplate contractTemplate) {
        mContractTemplate = contractTemplate;
        title.setText(contractTemplate.getName());
        date.setText(DateCalculator.getShortDate(contractTemplate.getDate()));
        contractType.setText(contractTemplate.getContractType().toUpperCase());
    }
}