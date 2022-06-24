package com.snoroc.stream.example1;

import java.util.*;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {

        List<Card> cards = getCards();

        //Old approach - Imperative mode
        List<Card> masterCards = new ArrayList<>();
        for(Card card : cards) {
            if(card.getCardType().equals(CardType.MASTER)) {
                masterCards.add(card);
            }
        }
        masterCards.forEach(System.out::println);

        System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ STREAM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        //New approach - Declarative mode
        //Filter + Sorted
        List<Card> masterCards2 = cards.stream()
                .filter(card -> card.getCardType().equals(CardType.MASTER))
                .sorted(Comparator.comparing(Card::getBalance).reversed())
                .collect(Collectors.toList());
        masterCards2.forEach(System.out::println);


        System.out.println("~~~~ All Match ~~~~ ");
        boolean allMatch = cards.stream()
                .allMatch(card -> card.getBalance() > 10000);
        System.out.println(allMatch);

        System.out.println("~~~~ Any Match ~~~~ ");
        boolean anyMatch = cards.stream()
                .anyMatch(card -> card.getBalance() > 10000);
        System.out.println(anyMatch);

        System.out.println("~~~~ Max ~~~~ ");
        Card maxBalance = cards.stream()
                .max(Comparator.comparing(Card::getBalance)).get();
        System.out.println(maxBalance);

        System.out.println("~~~~ Group ~~~~ ");
        Map<CardType, List<Card>> cardsType = cards.stream()
                .collect(Collectors.groupingBy(Card::getCardType));
        cardsType.forEach((cardType, cards1) -> {
            System.out.println(cardType);
            cards1.forEach(System.out::println);
            System.out.println();
        });

        System.out.println("~~~~ Chaining ~~~~ ");
        String owner = cards.stream()
                .filter(card -> card.getCardType().equals(CardType.VISA))
                .max(Comparator.comparing(Card::getBalance))
                .map(Card::getOwner).get();
        System.out.println(owner);
    }


    private static List<Card> getCards() {
        return List.of(
                new Card("Sergiu Noroc", 10000, true, CardType.VISA),
                new Card("Mihai Vozian", 12000, true, CardType.VISA),
                new Card("Dumitru Cazacu", 8000, true, CardType.MASTER),
                new Card("Alexandr Reznic", 15000, true, CardType.MASTER),
                new Card("Igor Panainte", 20000, true, CardType.VISA),
                new Card("Sergiu Motpan", 5000, true, CardType.VISA),
                new Card("Adrian Suparschi", 0, false, CardType.VISA),
                new Card("Olga Lihaia", 3000, true, CardType.VISA),
                new Card("Ina Tatarenco", 4000, true, CardType.VISA),
                new Card("Liviu Noroc", 1000, true, CardType.MASTER)
        );
    }
}
