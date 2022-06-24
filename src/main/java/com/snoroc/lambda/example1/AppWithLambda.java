package com.snoroc.lambda.example1;

import java.util.ArrayList;
import java.util.List;

public class AppWithLambda {

    public static void main(String[] args) {

        List<Card> cards = new ArrayList<Card>();
        cards.add(new Card("1234-1234-1234-1234", false, 1000));
        cards.add(new Card("3213-3213-3213-3213", true, 5000));
        cards.add(new Card("5678-5678-5678-5678", true, 4000));
        cards.add(new Card("3456-3456-3456-3456", false, 12000));

        print(cards, card -> card.active());
        System.out.println(" ~~~~~~~~~~~~~~~ ");
        print(cards, card -> card.balance() > 10000);
    }

    private static void print(List<Card> cards, CheckFeature checker) {
        for(Card card : cards) {
            if(checker.test(card)) {
                System.out.println(card + " ");
            }
        }
    }
}
