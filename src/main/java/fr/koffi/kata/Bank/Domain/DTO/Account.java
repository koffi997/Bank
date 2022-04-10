package fr.koffi.kata.Bank.Domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {
    private Long id;
    private String client;
    private Double balance;
}
