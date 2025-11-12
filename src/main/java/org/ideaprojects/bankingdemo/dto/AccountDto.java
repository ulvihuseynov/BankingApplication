package org.ideaprojects.bankingdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class AccountDto {
//
//    private Long id;
//    private String accountHolderName;
//    private Double balance;
//}

public record AccountDto(  Long id,
         String accountHolderName,
         Double balance) {


}
