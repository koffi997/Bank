package fr.koffi.kata.Bank.Domain.SPI;

import fr.koffi.kata.Bank.Domain.DTO.Account;
import org.jetbrains.annotations.NotNull;


public interface AccountPersitSpi {
    Account save (Account account);
    Account save (Long idClient, Double balance);
    Account update(Account account, @NotNull Long idAccount);
    Account find(Long idAccount);
}
