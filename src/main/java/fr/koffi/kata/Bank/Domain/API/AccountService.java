package fr.koffi.kata.Bank.Domain.API;

import fr.koffi.kata.Bank.Domain.DTO.Account;
import fr.koffi.kata.Bank.Domain.DTO.Mouvement;
import fr.koffi.kata.Bank.Domain.SPI.AccountPersitSpi;
import fr.koffi.kata.Bank.Domain.SPI.IAccountSpi;
import fr.koffi.kata.Bank.Domain.SPI.IMouvementSpi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountApi{
    private AccountPersitSpi accountPersitSpi;
    private IAccountSpi accountSpi;
    private IMouvementSpi mouvementSpi;

    public AccountService(AccountPersitSpi accountPersitSpi,
                          IMouvementSpi mouvementSpi) {
        this.accountPersitSpi = accountPersitSpi;
        this.mouvementSpi = mouvementSpi;
    }

    @Override
    public Account create(Account newClientAccount) {
        return accountPersitSpi.save(newClientAccount);
    }

    @Override
    public Account create(Long oldClientid, Double balance) {
        return accountPersitSpi.save(oldClientid,balance);
    }

    @Override
    public Mouvement deposit(Long idAccount, Double amount) {
        Mouvement mouvement=mouvementSpi.doDeposit(idAccount,amount);
        Account account = accountPersitSpi.find(idAccount);
        account.setBalance(account.getBalance()+amount);
        accountPersitSpi.update(account,idAccount);
        return mouvementSpi.find(mouvement.getId());
    }
    @Override
    public Mouvement withdrawal(Long idAccount, Double amount) {
        if(mouvementSpi.mouvementAvailability(idAccount,amount)){
            Mouvement mouvement=mouvementSpi.doWithdrawal(idAccount,amount);
            Account account = accountPersitSpi.find(idAccount);
            account.setBalance(account.getBalance()-amount);
            accountPersitSpi.update(account,idAccount);
            return mouvementSpi.find(mouvement.getId());
        }else {
            //Todo Throw Functionnal exception insufficient balance for this operation
            return null;
        }

    }

    @Override
    public List<Mouvement> consultation(Long idAccount) {
        return mouvementSpi.doConsult(idAccount);
    }
}
