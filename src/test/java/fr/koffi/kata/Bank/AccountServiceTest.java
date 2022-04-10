package fr.koffi.kata.Bank;


import fr.koffi.kata.Bank.Domain.API.IAccountApi;
import fr.koffi.kata.Bank.Domain.DTO.Account;
import fr.koffi.kata.Bank.Domain.SPI.AccountPersitSpi;
import fr.koffi.kata.Bank.Domain.SPI.IAccountSpi;
import fr.koffi.kata.Bank.Domain.SPI.IMouvementSpi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountServiceTest {

    @Autowired
    private IAccountApi accountApi;
    @Mock
    private AccountPersitSpi accountPersitSpi;
    @Mock
    private IAccountSpi accountSpi;
    @Mock
    private IMouvementSpi mouvementSpi;

    @Test
    public void create(){
        //jeu d'essai
        String name = "Koffi";
        Double balance = 85000.0;

        Account account = new Account();
        account.setClient(name);
        account.setBalance(balance);

        Account acc = accountApi.create(account);
        System.out.println(acc.getClient());

        //test
        Assertions.assertEquals(account.getBalance(),acc.getBalance());

    }




}
