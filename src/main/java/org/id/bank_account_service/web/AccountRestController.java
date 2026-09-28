package org.id.bank_account_service.web;


import org.id.bank_account_service.dto.BankAccountRequestDTO;
import org.id.bank_account_service.dto.BankAccountResponseDTO;
import org.id.bank_account_service.entities.BankAccount;
import org.id.bank_account_service.repositories.BankAccountRepository;
import org.id.bank_account_service.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("/api")
public class AccountRestController {

    private final  AccountService accountService;

    public AccountRestController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> bankAccountList(){
        return accountService.getAllAccounts();

    }


    @GetMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO getAccount(@PathVariable String id) {
        return accountService.getAccount(id);
    }



    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(BankAccountRequestDTO requestDTO){
       return  accountService.addAccount(requestDTO);
    }


    @PutMapping("/bankAccounts/{id}")
    public BankAccountResponseDTO update(
            @PathVariable String id,
            @RequestBody BankAccountRequestDTO requestDTO) {

        return accountService.updateAccount(id, requestDTO);
    }

    @DeleteMapping("/bankAccounts/{id}")
    public void delete(@PathVariable String id) {
        accountService.deleteAccount(id);
    }


}
