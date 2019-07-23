package com.eurekanetwork.wallet.ui.fragment.restore_contracts_fragment;

import com.eurekanetwork.wallet.model.ContractTemplate;
import com.eurekanetwork.wallet.model.backup.Backup;
import com.eurekanetwork.wallet.model.backup.ContractJSON;
import com.eurekanetwork.wallet.model.backup.TemplateJSON;
import com.eurekanetwork.wallet.model.contract.Contract;
import com.eurekanetwork.wallet.model.contract.Token;

import java.io.File;
import java.util.List;

public interface RestoreContractsInteractor {
    Backup getBackupFromFile(File restoreFile) throws Exception;

    List<ContractTemplate> getContractTemplates();

    ContractTemplate importTemplate(TemplateJSON templateJSON, List<ContractTemplate> templates);

    void putListWithoutToken(List<Contract> contractList);

    void putTokenList(List<Token> tokenList);

    boolean validateContractCreationAddress(ContractJSON contractJSON, List<TemplateJSON> templates);

    boolean getTemplateValidity(TemplateJSON templateJSON);

    boolean getContractValidity(ContractJSON contractJSON);
}
