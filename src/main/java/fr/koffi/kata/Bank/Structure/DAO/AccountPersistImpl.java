package fr.koffi.kata.Bank.Structure.DAO;

import fr.koffi.kata.Bank.Domain.DTO.Account;
import fr.koffi.kata.Bank.Domain.SPI.AccountPersitSpi;
import fr.koffi.kata.Bank.Framework.FonctionnalException;
import fr.koffi.kata.Bank.Framework.Mapper;
import fr.koffi.kata.Bank.Structure.DAO.Entity.AccountEntity;
import fr.koffi.kata.Bank.Structure.DAO.Entity.ClientEntity;
import fr.koffi.kata.Bank.Structure.DAO.Repo.IAccountRepository;
import fr.koffi.kata.Bank.Structure.DAO.Repo.IClientRepository;
import fr.koffi.kata.Bank.Structure.DAO.Repo.IMouvementRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class AccountPersistImpl implements AccountPersitSpi {

    private IAccountRepository accountRepository;
    private IClientRepository clientRepository;
    private IMouvementRepository mouvementRepository;

    public AccountPersistImpl(
            IAccountRepository accountRepository,
            IClientRepository clientRepository,
            IMouvementRepository mouvementRepository) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.mouvementRepository = mouvementRepository;
    }

    @Override
    public Account save(Account account) {
        AccountEntity accountEntity = Mapper.mapAccountDtoToEntity(account);
        AccountEntity accountSaved = accountRepository.save(accountEntity);
        return Mapper.mapAccountEntityToDTO(accountSaved);
    }

    @Override
    public Account save(Long idClient, Double balance) {
        ClientEntity clientEntity = clientRepository.findById(idClient).orElseThrow(
                () ->   new FonctionnalException("client","id",idClient));
        AccountEntity accountEntity = new AccountEntity() ;
        accountEntity.setClient(clientEntity);
        accountEntity.setBalance(balance);
        AccountEntity accountSaved = accountRepository.save(accountEntity);
        return Mapper.mapAccountEntityToDTO(accountSaved);
    }

    @Override
    public Account update(Account account, @NotNull Long idAccount) {
        AccountEntity accountEntityOld = accountRepository.findById(idAccount).orElseThrow(
                () -> new FonctionnalException("account","id",account));
        accountEntityOld.setBalance(account.getBalance());
        return Mapper.mapAccountEntityToDTO(accountRepository.save(accountEntityOld));
    }

    @Override
    public Account find(Long idAccount) {
        return Mapper.mapAccountEntityToDTO(accountRepository.findById(idAccount).orElseThrow(()->
                new FonctionnalException("account","id",idAccount)));
    }
}
