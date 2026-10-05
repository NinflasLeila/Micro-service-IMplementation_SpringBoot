package org.id.bank_account_service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@NoArgsConstructor @AllArgsConstructor @Builder
public class Customer {
    private Long id ;
    private String name ;


    @OneToMany(mappedBy = "customer")
    @JsonProperty
    private List<BankAccount> bankAccounts;
}
