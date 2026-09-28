package org.id.bank_account_service.service;

import org.id.bank_account_service.dto.BankAccountRequestDTO;
import org.id.bank_account_service.dto.BankAccountResponseDTO;
import org.id.bank_account_service.entities.BankAccount;

import java.util.List;

public interface AccountService {


    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDto);
    public List<BankAccountResponseDTO> getAllAccounts();
    public BankAccountResponseDTO updateAccount(String id , BankAccountRequestDTO bankAccountRequestDTO);
    public void deleteAccount(String id );
    public BankAccountResponseDTO getAccount(String id);

}
