package com.eurekanetwork.wallet.ui.fragment.other_tokens;

import com.eurekanetwork.wallet.model.contract.Token;

import java.util.List;

import rx.Observable;

public interface OtherTokensInteractor {
    Observable<List<Token>> getTokenObservable();
}
