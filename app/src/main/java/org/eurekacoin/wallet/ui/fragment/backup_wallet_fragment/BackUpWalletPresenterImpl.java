package com.eurekanetwork.wallet.ui.fragment.backup_wallet_fragment;

import com.eurekanetwork.wallet.BuildConfig;
import com.eurekanetwork.wallet.datastorage.KeyStorage;
import com.eurekanetwork.wallet.datastorage.EurekacoinSharedPreference;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragment;
import com.eurekanetwork.wallet.ui.base.base_fragment.BaseFragmentPresenterImpl;
import com.eurekanetwork.wallet.ui.fragment.confirm_passphrase_fragment.ConfirmPassphraseFragment;
import com.eurekanetwork.wallet.ui.fragment.wallet_main_fragment.WalletMainFragment;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BackUpWalletPresenterImpl extends BaseFragmentPresenterImpl implements BackUpWalletPresenter {

    private BackUpWalletView mBackUpWalletFragmentView;
    private BackUpWalletInteractor mBackUpWalletInteractor;
    private String passphrase;

    public BackUpWalletPresenterImpl(BackUpWalletView backUpWalletFragmentView, BackUpWalletInteractor backUpWalletInteractor) {
        mBackUpWalletFragmentView = backUpWalletFragmentView;
        mBackUpWalletInteractor = backUpWalletInteractor;
    }

    private BackUpWalletInteractor getInteractor() {
        return mBackUpWalletInteractor;
    }

    @Override
    public void initializeViews() {
        super.initializeViews();
        String pin = getView().getPin();
        passphrase = getInteractor().getPassphrase(pin);
        getView().setBrainCode(passphrase);
    }

    @Override
    public BackUpWalletView getView() {
        return mBackUpWalletFragmentView;
    }

    @Override
    public void onCopyBrainCodeClick() {
        getView().copyToClipboard(passphrase);
        getView().showToast();
    }

    @Override
    public void onShareClick() {
        getView().chooseShareMethod(passphrase);
    }

    @Override
    public void onContinueClick() {
//        if(BuildConfig.DEBUG) {
//
//            getView().setProgressDialog();
//            KeyStorage.getInstance().createWallet(passphrase)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Subscriber<String>() {
//                        @Override
//                        public void onCompleted() {
//
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//
//                        }
//
//                        @Override
//                        public void onNext(String s) {
//                            EurekacoinSharedPreference.getInstance().setKeyGeneratedInstance(getView().getContext(), true);
//                            getView().dismissProgressDialog();
//                            getView().onLogin();
//                        }
//                    });
//        } else {
            BaseFragment fragment = ConfirmPassphraseFragment.newInstance(getView().getContext(), passphrase);
            getView().openFragment(fragment);
//        }
   }
}
