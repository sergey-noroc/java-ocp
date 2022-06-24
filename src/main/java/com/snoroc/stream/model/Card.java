package com.snoroc.stream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private String owner;
    private String number;
    private int cvv;
    private int balance;
    private boolean isActive;
    private TypeCard typeCard;
    List<CardTransaction> cardTransactions;

}
