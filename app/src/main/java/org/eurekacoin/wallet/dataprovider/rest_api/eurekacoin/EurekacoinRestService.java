package com.eurekanetwork.wallet.dataprovider.rest_api.eurekacoin;

import com.eurekanetwork.wallet.model.gson.BlockChainInfo;

import com.eurekanetwork.wallet.model.gson.CallSmartContractRequest;
import com.eurekanetwork.wallet.model.gson.ContractParams;
import com.eurekanetwork.wallet.model.gson.DGPInfo;
import com.eurekanetwork.wallet.model.gson.ExistContractResponse;
import com.eurekanetwork.wallet.model.gson.FeePerKb;
import com.eurekanetwork.wallet.model.gson.QstoreContractType;
import com.eurekanetwork.wallet.model.gson.call_smart_contract_response.CallSmartContractResponse;
import com.eurekanetwork.wallet.model.gson.history.History;
import com.eurekanetwork.wallet.model.gson.history.HistoryResponse;
import com.eurekanetwork.wallet.model.gson.SendRawTransactionRequest;
import com.eurekanetwork.wallet.model.gson.SendRawTransactionResponse;
import com.eurekanetwork.wallet.model.gson.UnspentOutput;
import com.eurekanetwork.wallet.model.gson.history.TransactionReceipt;
import com.eurekanetwork.wallet.model.gson.qstore.ContractPurchase;
import com.eurekanetwork.wallet.model.gson.qstore.QSearchItem;
import com.eurekanetwork.wallet.model.gson.qstore.QstoreBuyResponse;
import com.eurekanetwork.wallet.model.gson.qstore.QstoreByteCodeResponse;
import com.eurekanetwork.wallet.model.gson.qstore.QstoreContract;
import com.eurekanetwork.wallet.model.gson.qstore.QstoreItem;
import com.eurekanetwork.wallet.model.gson.qstore.QstoreSourceCodeResponse;
import com.eurekanetwork.wallet.model.gson.token_history.TokenHistoryResponse;

import java.util.HashMap;
import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

interface EurekacoinRestService {

    @GET("/outputs/unspent/{address}")
    Observable<List<UnspentOutput>> getOutputsUnspent(@Path("address") String address);

    @GET("/history/{address}/{limit}/{offset}")
    Observable<List<History>> getHistoryList(@Path("address") String address, @Path("limit") int limit, @Path("offset") int offset);

    @GET("/blockchain/info")
    Observable<BlockChainInfo> getBlockChainInfo();

    @POST("/send-raw-transaction")
    Observable<SendRawTransactionResponse> sendRawTransaction(@Body SendRawTransactionRequest sendRawTransactionRequest);

    @POST("/contracts/{addressContract}/call")
    Observable<CallSmartContractResponse> callSmartContract(@Path("addressContract") String addressContract, @Body CallSmartContractRequest callSmartContractRequest);

    @GET("/outputs/unspent")
    Observable<List<UnspentOutput>> getUnspentOutputsForSeveralAddresses(@Query("addresses[]") List<String> addresses);

    @GET("/history/{limit}/{offset}")
    Observable<HistoryResponse> getHistoryListForSeveralAddresses(@Path("limit") int limit, @Path("offset") int offset, @Query("addresses[]") List<String> addresses);

    @GET("/transactions/{tx_hash}")
    Observable<History> getTransaction(@Path("tx_hash") String txHash);

    @GET("/contracts/trending-now")
    Observable<List<QstoreItem>> getTrendingNow();

    @GET("/contracts/last-added")
    Observable<List<QstoreItem>> getWatsNew();

    @GET("/contracts/{count}/{offset}")
    Observable<List<QSearchItem>> getSearchContracts(@Path("count") int count, @Path("offset") int offset, @Query("type") String type, @Query("tags[]") String[] tags); //by tag

    @GET("/contracts/{count}/{offset}")
    Observable<List<QSearchItem>> getSearchContracts(@Path("count") int count, @Path("offset") int offset, @Query("type") String type, @Query("name") String name); //by name

    @GET("/contracts/{contract_id}")
    Observable<QstoreContract> getContract(@Path("contract_id") String contractId);

    @POST("/contracts/{contract_id}/source-code")
    Observable<QstoreSourceCodeResponse> getSourceCode(@Path("contract_id") String contractId, @Body HashMap<String, String> body);

    @POST("/contracts/{contract_id}/bytecode")
    Observable<QstoreByteCodeResponse> getByteCode(@Path("contract_id") String contractId, @Body HashMap<String, String> body);

    @GET("/contracts/{contract_id}/abi")
    Observable<Object> getAbiByContractId(@Path("contract_id") String contractId);

    @POST("/contracts/{contract_id}/buy-request")
    Observable<QstoreBuyResponse> buyRequest(@Path("contract_id") String contractId);

    @GET("/contracts/{contract_id}/is-paid/by-request-id")
    Observable<ContractPurchase> isPaidByRequestId(@Path("contract_id") String contractId, @Query("request_id") String requestId);

    @GET("/estimate-fee-per-kb")
    Observable<FeePerKb> getEstimateFeePerKb(@Query("nBlocks") int nBlocks);

    @GET("/contracts/types")
    Observable<List<QstoreContractType>> getContractTypes();

    @GET("/blockchain/dgpinfo")
    Observable<DGPInfo> getDGPInfo();

    @GET("/contracts/{addressContract}/params?keys=symbol,decimals,name,totalSupply")
    Observable<ContractParams> getContractParams(@Path("addressContract") String addressContract);


    @GET("/contracts/{addressContract}/exists")
    Observable<ExistContractResponse> isContractExist(@Path("addressContract") String addressContract);

    @GET("/erc20/{erc20ContractAddress}/transfers")
    Observable<TokenHistoryResponse> getTokenHistoryList(@Path("erc20ContractAddress") String erc20ContractAddress, @Query("limit") int limit, @Query("offset") int offset, @Query("addresses[]") List<String> addresses);

    @GET("/transactions/{txhash}/receipt")
    Observable<List<TransactionReceipt>> getTransactionReceipt(@Path("txhash") String txHash);

}