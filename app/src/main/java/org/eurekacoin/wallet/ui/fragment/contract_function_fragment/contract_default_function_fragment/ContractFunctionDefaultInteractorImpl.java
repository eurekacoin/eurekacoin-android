package com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.contract_default_function_fragment;

import android.content.Context;

import org.bitcoinj.script.Script;
import com.eurekanetwork.wallet.dataprovider.rest_api.eurekacoin.EurekacoinService;
import com.eurekanetwork.wallet.datastorage.FileStorageManager;
import com.eurekanetwork.wallet.datastorage.KeyStorage;
import com.eurekanetwork.wallet.datastorage.EurekacoinSettingSharedPreference;
import com.eurekanetwork.wallet.datastorage.EurekacoinSharedPreference;
import com.eurekanetwork.wallet.datastorage.TinyDB;
import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.model.contract.ContractMethod;
import com.eurekanetwork.wallet.model.contract.ContractMethodParameter;
import com.eurekanetwork.wallet.model.gson.CallSmartContractRequest;
import com.eurekanetwork.wallet.model.gson.SendRawTransactionRequest;
import com.eurekanetwork.wallet.model.gson.SendRawTransactionResponse;
import com.eurekanetwork.wallet.model.gson.UnspentOutput;
import com.eurekanetwork.wallet.model.gson.call_smart_contract_response.CallSmartContractResponse;
import com.eurekanetwork.wallet.utils.ContractBuilder;

import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.List;

import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;

public class ContractFunctionDefaultInteractorImpl implements ContractFunctionDefaultInteractor {

    private WeakReference<Context> mContext;

    public ContractFunctionDefaultInteractorImpl(Context context) {
        mContext = new WeakReference<>(context);
    }

    @Override
    public List<ContractMethod> getContractMethod(String contractTemplateUiid) {
        return FileStorageManager.getInstance().getContractMethods(mContext.get(), contractTemplateUiid);
    }

    @Override
    public BigDecimal getFeePerKb() {
        EurekacoinSettingSharedPreference eurekacoinSettingSharedPreference = EurekacoinSettingSharedPreference.getInstance();
        return new BigDecimal(eurekacoinSettingSharedPreference.getFeePerKb(mContext.get()));
    }

    @Override
    public int getMinGasPrice() {
        return EurekacoinSharedPreference.getInstance().getMinGasPrice(mContext.get());
    }

    @Override
    public Observable<CallSmartContractRespWrapper> callSmartContractObservable(final String methodName, final List<ContractMethodParameter> contractMethodParameterList, final Contract contract, final String addressFrom) {
        final CallSmartContractRespWrapper wrapper = new CallSmartContractRespWrapper();
        return Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                ContractBuilder contractBuilder = new ContractBuilder();
                return contractBuilder.createAbiMethodParams(methodName, contractMethodParameterList);
            }
        }).flatMap(new Func1<String, Observable<CallSmartContractResponse>>() {
            @Override
            public Observable<CallSmartContractResponse> call(String s) {
                wrapper.setAbiParams(s);
                return EurekacoinService.newInstance().callSmartContract(contract.getContractAddress(), new CallSmartContractRequest(new String[]{s}, addressFrom));
            }
        }).map(new Func1<CallSmartContractResponse, CallSmartContractRespWrapper>() {
            @Override
            public CallSmartContractRespWrapper call(CallSmartContractResponse response) {
                wrapper.setResponse(response);
                return wrapper;
            }
        });
    }

    @Override
    public Observable<List<UnspentOutput>> unspentOutputsForAddressObservable(final String address) {
        return Observable.defer(new Func0<Observable<List<UnspentOutput>>>() {
            @Override
            public Observable<List<UnspentOutput>> call() {
                return EurekacoinService.newInstance().getUnspentOutputs(address);
            }
        });
    }

    @Override
    public String createTransactionHash(String abiParams, List<UnspentOutput> unspentOutputs, int gasLimit, int gasPrice, BigDecimal feePerKb, String fee, final String contractAddress, String sendToContract, String passphrase) {
        ContractBuilder contractBuilder = new ContractBuilder();
        Script script = contractBuilder.createMethodScript(abiParams, gasLimit, gasPrice, contractAddress);

        return contractBuilder.createTransactionHash(script, unspentOutputs, gasLimit, gasPrice, feePerKb, fee, sendToContract,mContext.get(), passphrase);
    }

    @Override
    public Observable<SendRawTransactionResponse> sendRawTransactionObservable(String code) {
        return EurekacoinService.newInstance().sendRawTransaction(new SendRawTransactionRequest(code, 1));
    }

    @Override
    public Contract getContractByAddress(String address) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        for (Contract contract : tinyDB.getContractList()) {
            if (contract.getContractAddress().equals(address)) {
                return contract;
            }
        }
        return null;
    }

    @Override
    public List<String> getAddresses() {
        return KeyStorage.getInstance().getAddresses();
    }

    @Override
    public Observable<List<UnspentOutput>> getUnspentOutputs(List<String> addresses) {
        return EurekacoinService.newInstance().getUnspentOutputsForSeveralAddresses(addresses);
    }

    public static class CallSmartContractRespWrapper {
        private String abiParams;
        private CallSmartContractResponse response;

        public CallSmartContractRespWrapper(String abiParams, CallSmartContractResponse response) {
            this.abiParams = abiParams;
            this.response = response;
        }

        public CallSmartContractRespWrapper() {

        }

        public String getAbiParams() {
            return abiParams;
        }

        public void setAbiParams(String abiParams) {
            this.abiParams = abiParams;
        }

        public CallSmartContractResponse getResponse() {
            return response;
        }

        public void setResponse(CallSmartContractResponse response) {
            this.response = response;
        }
    }
}
