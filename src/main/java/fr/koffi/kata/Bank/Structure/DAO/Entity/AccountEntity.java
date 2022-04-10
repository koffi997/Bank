package fr.koffi.kata.Bank.Structure.DAO.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double balance;
    @ManyToOne(cascade = CascadeType.ALL)
    private ClientEntity client;
    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
    private List<MouvementEntity> mouvement;
}
