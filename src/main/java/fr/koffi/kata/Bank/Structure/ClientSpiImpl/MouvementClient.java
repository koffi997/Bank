package fr.koffi.kata.Bank.Structure.ClientSpiImpl;

import fr.koffi.kata.Bank.Domain.DTO.Mouvement;
import fr.koffi.kata.Bank.Domain.SPI.IMouvementSpi;
import fr.koffi.kata.Bank.Framework.FonctionnalException;
import fr.koffi.kata.Bank.Framework.Mapper;
import fr.koffi.kata.Bank.Structure.DAO.Entity.AccountEntity;
import fr.koffi.kata.Bank.Structure.DAO.Entity.MouvementEntity;
import fr.koffi.kata.Bank.Structure.DAO.Repo.IAccountRepository;
import fr.koffi.kata.Bank.Structure.DAO.Repo.IMouvementRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MouvementClient implements IMouvementSpi {

    IMouvementRepository mouvementRepository;
    IAccountRepository accountRepository;


    public MouvementClient(IMouvementRepository mouvementRepository, IAccountRepository accountRepository) {
        this.mouvementRepository = mouvementRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public boolean mouvementAvailability(Long idAccount, Double amount) {
        AccountEntity accountEntity = accountRepository.findById(idAccount).orElseThrow(
                () -> new FonctionnalException("account","id",idAccount));
        if(accountEntity.getBalance() >= amount){
            return true;
        }
        return false;
    }

    @Override
    public Mouvement doDeposit(Long account, Double amount) throws FonctionnalException {
        AccountEntity accountEntity = accountRepository.findById(account).orElseThrow(
                () -> new FonctionnalException("account","id",account));

        MouvementEntity mouvementEntity= new MouvementEntity();
        mouvementEntity.setType("deposit");
        mouvementEntity.setAmount(amount);
        mouvementEntity.setMvementdate(new Timestamp(System.currentTimeMillis()));
        mouvementEntity.setAccount(accountEntity);

        mouvementRepository.save(mouvementEntity);
        return Mapper.mapMouvementEntityToDTO(mouvementRepository.save(mouvementEntity));
    }

    @Override
    public Mouvement find(Long id) throws FonctionnalException {
        MouvementEntity mouvementEntity = mouvementRepository.findById(id).orElseThrow(
                () -> new FonctionnalException("account","id",id));
        return Mapper.mapMouvementEntityToDTO(mouvementEntity);
    }

    @Override
    public Mouvement doWithdrawal(Long account, Double amount) {
        AccountEntity accountEntity = accountRepository.findById(account).orElseThrow(
                () -> new FonctionnalException("account","id",account));

        MouvementEntity mouvementEntity= new MouvementEntity();
        mouvementEntity.setType("withdrawal");
        mouvementEntity.setAmount(amount);
        mouvementEntity.setMvementdate(new Timestamp(System.currentTimeMillis()));
        mouvementEntity.setAccount(accountEntity);

        mouvementRepository.save(mouvementEntity);
        return Mapper.mapMouvementEntityToDTO(mouvementRepository.save(mouvementEntity));
    }

    @Override
    public List<Mouvement> doConsult(Long account) {
        AccountEntity accountEntity = accountRepository.findById(account).orElseThrow(
                () -> new FonctionnalException("account","id",account));

        return Mapper.mapMouvementEntitysToDTOs(accountEntity.getMouvement());
    }
}
