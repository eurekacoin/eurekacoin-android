package com.eurekanetwork.wallet.ui.fragment.token_cash_management_fragment;

import com.eurekanetwork.wallet.model.AddressWithTokenBalance;
import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.model.gson.token_balance.TokenBalance;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenter;

import java.util.List;

public interface AddressesListTokenPresenter extends BaseFragmentPresenter {
    String getContractAddress();

    void setTokenBalance(TokenBalance tokenBalance);

    void processTokenBalances(TokenBalance tokenBalance);

    void setToken(Token token);

    void setCurrency(String currency);

    int getDecimalUnits();

    List<AddressWithTokenBalance> getKeysWithTokenBalance();

    String getCurrency();

    void setKeyWithTokenBalanceFrom(AddressWithTokenBalance itemAtPosition);

    AddressWithTokenBalance getKeyWithTokenBalanceFrom();

    void transfer(AddressWithTokenBalance keyWithBalanceTo, AddressWithTokenBalance keyWithTokenBalanceFrom, String s);
}
