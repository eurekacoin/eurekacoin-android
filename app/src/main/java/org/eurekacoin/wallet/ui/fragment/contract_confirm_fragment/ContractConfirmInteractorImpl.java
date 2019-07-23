package com.eurekanetwork.wallet.ui.fragment.contract_confirm_fragment;

import android.content.Context;

import org.bitcoinj.script.Script;
import com.eurekanetwork.wallet.dataprovider.rest_api.eurekacoin.EurekacoinService;
import com.eurekanetwork.wallet.datastorage.KeyStorage;
import com.eurekanetwork.wallet.datastorage.EurekacoinSettingSharedPreference;
import com.eurekanetwork.wallet.datastorage.EurekacoinSharedPreference;
import com.eurekanetwork.wallet.datastorage.TinyDB;
import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.model.TransactionHashWithSender;
import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.model.contract.ContractCreationStatus;
import com.eurekanetwork.wallet.model.contract.ContractMethodParameter;
import com.eurekanetwork.wallet.model.contract.Token;
import com.eurekanetwork.wallet.model.gson.SendRawTransactionRequest;
import com.eurekanetwork.wallet.model.gson.SendRawTransactionResponse;
import com.eurekanetwork.wallet.model.gson.UnspentOutput;
import com.eurekanetwork.wallet.utils.ContractBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;

class ContractConfirmInteractorImpl implements ContractConfirmInteractor {

    Context mContext;

    ContractConfirmInteractorImpl(Context context) {
        mContext = context;
    }

    @Override
    public Observable<String> createAbiConstructParams(List<ContractMethodParameter> contractMethodParameterList, String uiid) {
        ContractBuilder contractBuilder = new ContractBuilder();
        return contractBuilder.createAbiConstructParams(contractMethodParameterList, uiid, mContext);
    }

    @Override
    public Observable<List<UnspentOutput>> getUnspentOutputsForSeveralAddresses() {
        return EurekacoinService.newInstance().getUnspentOutputsForSeveralAddresses(KeyStorage.getInstance().getAddresses());
    }

    @Override
    public Observable<SendRawTransactionResponse> sendRawTransaction(SendRawTransactionRequest sendRawTransactionRequest) {
        return EurekacoinService.newInstance().sendRawTransaction(sendRawTransactionRequest);
    }

    @Override
    public void saveContract(String txid, String contractTemplateUiid, String contractName, String senderAddress) {
        TinyDB tinyDB = new TinyDB(mContext);
        ArrayList<String> unconfirmedTokenTxHashList = tinyDB.getUnconfirmedContractTxHasList();
        unconfirmedTokenTxHashList.add(txid);
        tinyDB.putUnconfirmedContractTxHashList(unconfirmedTokenTxHashList);
        for (ContractTemplate contractTemplate : tinyDB.getContractTemplateList()) {
            if (contractTemplate.getUuid().equals(contractTemplateUiid)) {
                if (contractTemplate.getContractType().equals("token") || contractTemplate.getContractType().equals("crowdsale")) {
                    saveToken(tinyDB, txid, contractTemplateUiid, contractName, senderAddress);
                } else {
                    saveContract(tinyDB, txid, contractTemplateUiid, contractName, senderAddress);
                }
            }
        }
    }

    private void saveToken(TinyDB tinyDB, String txid, String contractTemplateUiid, String contractName, String senderAddress) {
        Token token = new Token(ContractBuilder.generateContractAddress(txid), contractTemplateUiid, ContractCreationStatus.Unconfirmed, null, senderAddress, contractName);
        List<Token> tokenList = tinyDB.getTokenList();
        tokenList.add(token);
        tinyDB.putTokenList(tokenList);
    }

    private void saveContract(TinyDB tinyDB, String txid, String contractTemplateUiid, String contractName, String senderAddress) {
        Contract contract = new Contract(ContractBuilder.generateContractAddress(txid), contractTemplateUiid, ContractCreationStatus.Unconfirmed, null, senderAddress, contractName);
        List<Contract> contractList = tinyDB.getContractListWithoutToken();
        contractList.add(contract);
        tinyDB.putContractListWithoutToken(contractList);
    }

    @Override
    public TransactionHashWithSender createTransactionHash(String abiParams, List<UnspentOutput> unspentOutputs, int gasLimit, int gasPrice, String fee, String passphrase) {
        ContractBuilder contractBuilder = new ContractBuilder();
        Script script = contractBuilder.createConstructScript(abiParams, gasLimit, gasPrice);
        return contractBuilder.createTransactionHashForCreateContract(script, unspentOutputs, gasLimit, gasPrice, getFeePerKb(), fee, mContext, passphrase);
    }

    @Override
    public BigDecimal getFeePerKb() {
        EurekacoinSettingSharedPreference eurekacoinSettingSharedPreference = EurekacoinSettingSharedPreference.getInstance();
        return new BigDecimal(eurekacoinSettingSharedPreference.getFeePerKb(mContext));
    }

    @Override
    public int getMinGasPrice() {
        return EurekacoinSharedPreference.getInstance().getMinGasPrice(mContext);
    }
}
