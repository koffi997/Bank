package fr.koffi.kata.Bank.Domain.API;

import fr.koffi.kata.Bank.Domain.DTO.Account;
import fr.koffi.kata.Bank.Domain.DTO.Mouvement;

import java.util.List;

public interface IAccountApi {
    Account create(Account newClientAccount);
    Account create(Long oldClientid,Double balance);
    Mouvement deposit(Long idAccount, Double amount);
    Mouvement withdrawal(Long idAccount,Double amount);
    List<Mouvement> consultation(Long idAccount);
}
