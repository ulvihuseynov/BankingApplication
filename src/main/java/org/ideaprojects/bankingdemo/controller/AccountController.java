package org.ideaprojects.bankingdemo.controller;

import org.ideaprojects.bankingdemo.dto.AccountDto;
import org.ideaprojects.bankingdemo.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/add")
    public ResponseEntity<AccountDto> addAccount (@RequestBody AccountDto accountDto){

        return new ResponseEntity<>(accountService.createAccount(accountDto),HttpStatus.CREATED);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<AccountDto> getAccountById (@PathVariable Long id){

        return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit (@PathVariable Long id,
                                                 @RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        return new ResponseEntity<>(accountService.deposit(id,amount),HttpStatus.OK);
    }

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw (@PathVariable Long id,
                                                  @RequestBody Map<String,Double> request){
        Double amount = request.get("amount");
        return new ResponseEntity<>(accountService.withdraw(id,amount),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<AccountDto>> getAllAccounts (){

        return new ResponseEntity<>(accountService.getAllAccounts(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount (@PathVariable Long id){
        accountService.deleteAccount(id);
        return new ResponseEntity<>("Successfully deleted account by id "+id,HttpStatus.OK);
    }
}
