package com.snoroc.stream.filter;

import com.snoroc.stream.model.Card;
import com.snoroc.stream.model.TypeCard;

import java.util.List;

public class App {

    public static void main(String[] args) {

        getCards().stream()
                .filter(card -> card.getTypeCard().equals(TypeCard.MASTER))
                .forEach(System.out::println);

        System.out.println("~~~ Filter with Condition ~~~");

        getCards().stream()
                .filter(card -> {
                    if(card.getBalance() == 0) {
                        //TODO: send notification
                        return true;
                    }
                    return false;
                })
                .forEach(System.out::println);

    }



    private static List<Card> getCards() {
        return List.of(
                new Card("Sergiu Noroc", "1234-1234-1234-1234", 566, 10000, true, TypeCard.VISA),
                new Card("Mihai Vozian", "3456-3456-3456-3456", 589, 8000, true, TypeCard.VISA),
                new Card("Dumitru Cazacu", "9876-9876-9876-9876", 963, 5000, true, TypeCard.MASTER),
                new Card("Sergiu Motpan", "6543-6543-6543-6543", 189, 20000, true, TypeCard.VISA),
                new Card("Alexandr Reznic", "1456-1456-1456-1456", 278, 15000, true, TypeCard.MASTER),
                new Card("Olha Lihaia", "0987-0987-0987-0987", 311, 3000, true, TypeCard.VISA),
                new Card("Adrian Suparschi", "5567-5567-5567-5567", 497, 1000, true, TypeCard.MASTER),
                new Card("Igor Panainte", "6899-6899-6543-6123", 199, 0, false, TypeCard.VISA)
        );
    }
}
