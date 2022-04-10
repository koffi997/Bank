package fr.koffi.kata.Bank.Structure.DAO.Repo;

import fr.koffi.kata.Bank.Structure.DAO.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientEntity,Long> {
}
