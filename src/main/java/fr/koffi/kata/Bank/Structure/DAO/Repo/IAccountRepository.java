package fr.koffi.kata.Bank.Structure.DAO.Repo;

import fr.koffi.kata.Bank.Structure.DAO.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity,Long> {
}
