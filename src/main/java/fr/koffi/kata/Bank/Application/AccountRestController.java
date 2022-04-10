package fr.koffi.kata.Bank.Application;

import fr.koffi.kata.Bank.Domain.API.IAccountApi;
import fr.koffi.kata.Bank.Domain.DTO.Account;
import fr.koffi.kata.Bank.Domain.DTO.Mouvement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountRestController {
    private IAccountApi accountApi;

    public AccountRestController(IAccountApi accountApi) {
        this.accountApi = accountApi;
    }

    @PostMapping
    ResponseEntity<Account> create(@RequestBody Account newClientAccount){
        return new ResponseEntity<Account>(accountApi.create(newClientAccount), HttpStatus.CREATED);
    };

    @PostMapping("{id}")
    ResponseEntity<Account> create(@PathVariable("id") Long oldClientid, @RequestParam("balance") Double balance) {
        return new ResponseEntity<Account>(accountApi.create(oldClientid,balance), HttpStatus.CREATED);
    }
    @PostMapping("deposit/{id}")
    ResponseEntity<Mouvement> deposit(@PathVariable("id") Long idAccount, @RequestParam("amount") Double amount) {
        return new ResponseEntity<Mouvement>(accountApi.deposit(idAccount,amount),HttpStatus.OK);
    }
    @PostMapping("withdrawal/{id}")
    ResponseEntity<Mouvement> withdrawal(@PathVariable("id") Long idAccount, @RequestParam("amount") Double amount) {
        return new ResponseEntity<Mouvement>(accountApi.withdrawal(idAccount,amount),HttpStatus.OK);
    }
    @GetMapping("{id}")
    ResponseEntity<List<Mouvement>> consultation(@PathVariable("id") Long idAccount) {
        return new ResponseEntity<List<Mouvement>>(accountApi.consultation(idAccount),HttpStatus.OK);
    }
}
