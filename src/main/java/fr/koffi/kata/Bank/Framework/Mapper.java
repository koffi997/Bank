package fr.koffi.kata.Bank.Framework;

import fr.koffi.kata.Bank.Domain.DTO.Account;
import fr.koffi.kata.Bank.Domain.DTO.Mouvement;
import fr.koffi.kata.Bank.Structure.DAO.Entity.AccountEntity;
import fr.koffi.kata.Bank.Structure.DAO.Entity.ClientEntity;
import fr.koffi.kata.Bank.Structure.DAO.Entity.MouvementEntity;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static Account mapAccountEntityToDTO(AccountEntity accountEntity){
        Account account=null;
        if (accountEntity != null){
            account = new Account();
            account.setId(accountEntity.getId());
            account.setClient(accountEntity.getClient().getName());
            account.setBalance(accountEntity.getBalance());
        }
        return account;
    }
    public static AccountEntity mapAccountDtoToEntity(Account accountDTO){
        AccountEntity accountEntity = null;
        if(accountDTO != null){
            ClientEntity clientEntity = new ClientEntity();
            clientEntity.setName(accountDTO.getClient());
            accountEntity= new AccountEntity();
            accountEntity.setId(accountDTO.getId());
            accountEntity.setClient(clientEntity);
            accountEntity.setBalance(accountDTO.getBalance());
        }
        return accountEntity;
    }
    public static Mouvement mapMouvementEntityToDTO(MouvementEntity mouvementEntity){
        Mouvement mouvement = null;
        if(mouvementEntity != null){
            mouvement=new Mouvement();
            mouvement.setId(mouvementEntity.getId());
            mouvement.setAccount(mouvementEntity.getAccount().getId());
            mouvement.setMvementdate(mouvementEntity.getMvementdate());
            mouvement.setAmount(mouvementEntity.getAmount());
            mouvement.setType(mouvementEntity.getType());
            mouvement.setBalance(mouvementEntity.getAccount().getBalance());

        }
        return mouvement;
    }
    public  static List<Mouvement> mapMouvementEntitysToDTOs(List<MouvementEntity> mouvementEntities){
        List<Mouvement> mouvements = new ArrayList<>();
        mouvementEntities.forEach(mouvementEntity -> mouvements.add(mapMouvementEntityToDTO(mouvementEntity)));
        return  mouvements;
    }
}
