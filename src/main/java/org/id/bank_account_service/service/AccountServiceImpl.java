package org.id.bank_account_service.service;

import org.id.bank_account_service.dto.BankAccountRequestDTO;
import org.id.bank_account_service.dto.BankAccountResponseDTO;
import org.id.bank_account_service.entities.BankAccount;
import org.id.bank_account_service.mappers.AccountMapper;
import org.id.bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAT(new Date())
                .balance(bankAccountDto.getBalance())
                .type(bankAccountDto.getType())
                .currency(bankAccountDto.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
        BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }



    // read one account
    @Override
    public BankAccountResponseDTO getAccount(String id){
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found!"));
        return accountMapper.fromBankAccount(bankAccount);
    }


    // get all
    @Override
    public List<BankAccountResponseDTO> getAllAccounts() {

        List<BankAccount> accounts = bankAccountRepository.findAll();
        return accounts.stream()
                .map(accountMapper::fromBankAccount)
                .collect(Collectors.toList())
                ;
    }

    // update
    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found!"));

        bankAccount.setBalance(bankAccountRequestDTO.getBalance());
        bankAccount.setType(bankAccountRequestDTO.getType());
        bankAccount.setCurrency(bankAccountRequestDTO.getCurrency());
        BankAccount updatedBankAccount = bankAccountRepository.save(bankAccount);
        return accountMapper.fromBankAccount(updatedBankAccount);
    }

    @Override
    public void deleteAccount(String id) {
        if( !bankAccountRepository.existsById(id)){
            throw new RuntimeException("Account not found!");
        }
        bankAccountRepository.deleteById(id);

    }





}
