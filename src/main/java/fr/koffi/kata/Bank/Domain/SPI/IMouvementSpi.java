package fr.koffi.kata.Bank.Domain.SPI;

import fr.koffi.kata.Bank.Domain.DTO.Mouvement;
import fr.koffi.kata.Bank.Framework.FonctionnalException;

import java.util.List;

public interface IMouvementSpi {
    boolean mouvementAvailability(Long idAccount,Double amount);
    Mouvement doDeposit(Long account, Double amount);
    Mouvement find(Long id) throws FonctionnalException;
    Mouvement doWithdrawal(Long account, Double amount);
    List<Mouvement> doConsult (Long account);
}
