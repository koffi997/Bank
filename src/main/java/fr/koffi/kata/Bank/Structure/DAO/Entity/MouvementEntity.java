package fr.koffi.kata.Bank.Structure.DAO.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "mouvement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MouvementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private AccountEntity account;
    //depot ou retrait
    private String type;
    private Timestamp mvementdate;
    private Double amount;
}
