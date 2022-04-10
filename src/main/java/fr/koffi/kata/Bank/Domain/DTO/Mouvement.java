package fr.koffi.kata.Bank.Domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Mouvement {
    private Long id;
    private Long account;
    //depot ou retrait
    private String type;
    private Timestamp mvementdate;
    private Double amount;
    private Double balance;
}
