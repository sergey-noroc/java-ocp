package com.snoroc.stream.map;

import com.snoroc.stream.model.Card;
import com.snoroc.stream.model.TypeCard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class App {

    public static void main(String[] args) {

        getCards().stream()
                .map(card -> card.getBalance())
                //.map(Card::getBalance) //the same
                .forEach(System.out::println);

        getCards().stream()
                .map(card -> {
                    if(!card.isActive()) {
                        //TODO: something
                    }
                    return new Date();
                }).forEach(System.out::println);
    }

    private static List<Card> getCards() {
        return Arrays.asList(
                new Card("Sergiu Noroc", "1234-1234-1234-1234", 566, 10000, true, TypeCard.VISA, List.of()),
                new Card("Mihai Vozian", "3456-3456-3456-3456", 589, 8000, true, TypeCard.VISA, List.of()),
                new Card("Dumitru Cazacu", "9876-9876-9876-9876", 963, 5000, true, TypeCard.MASTER, List.of()),
                new Card("Sergiu Motpan", "6543-6543-6543-6543", 189, 20000, true, TypeCard.VISA, List.of()),
                new Card("Alexandr Reznic", "1456-1456-1456-1456", 278, 15000, true, TypeCard.MASTER, List.of()),
                new Card("Olha Lihaia", "0987-0987-0987-0987", 311, 3000, true, TypeCard.VISA, List.of()),
                new Card("Adrian Suparschi", "5567-5567-5567-5567", 497, 1000, true, TypeCard.MASTER, List.of()),
                new Card("Igor Panainte", "6899-6899-6543-6123", 199, 0, false, TypeCard.VISA, List.of())
        );
    }
}
