package com.eurekanetwork.wallet.ui.fragment.contract_function_fragment.contract_constant_function_fragment;

import android.content.Context;

import org.bitcoinj.script.Script;
import com.eurekanetwork.wallet.dataprovider.rest_api.eurekacoin.EurekacoinService;
import com.eurekanetwork.wallet.datastorage.FileStorageManager;
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

public class ContractFunctionConstantInteractorImpl implements ContractFunctionConstantInteractor {

    private WeakReference<Context> mContext;

    public ContractFunctionConstantInteractorImpl(Context context) {
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
    public Observable<CallSmartContractRespWrapper> callSmartContractObservable(final String methodName, final List<ContractMethodParameter> contractMethodParameterList, final Contract contract) {
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
                return EurekacoinService.newInstance().callSmartContract(contract.getContractAddress(), new CallSmartContractRequest(new String[]{s}, contract.getSenderAddress()));
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
    public Contract getContractByAddress(String address) {
        TinyDB tinyDB = new TinyDB(mContext.get());
        for (Contract contract : tinyDB.getContractList()) {
            if (contract.getContractAddress().equals(address)) {
                return contract;
            }
        }
        return null;
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
