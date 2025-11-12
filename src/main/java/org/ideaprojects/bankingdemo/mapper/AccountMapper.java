package org.ideaprojects.bankingdemo.mapper;

import org.ideaprojects.bankingdemo.dto.AccountDto;
import org.ideaprojects.bankingdemo.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){

        return new Account(
                accountDto.id(),
                accountDto.accountHolderName(),
                accountDto.balance()
        );
    }

    public static AccountDto mapToAccountDto(Account account){

        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}

