package com.snoroc.lambda.example1;

import java.util.ArrayList;
import java.util.List;

public class AppWithoutLambda {

    public static void main(String[] args) {

        var cards = new ArrayList<Card>();
        cards.add(new Card("1234-1234-1234-1234", false, 1000));
        cards.add(new Card("3213-3213-3213-3213", true, 5000));
        cards.add(new Card("5678-5678-5678-5678", true, 4000));
        cards.add(new Card("3456-3456-3456-3456", false, 12000));

        print(cards, new CheckIfActive());
    }

    private static void print(List<Card> cards, CheckFeature checker) {
        for(Card card : cards) {
            if(checker.test(card)) {
                System.out.println(card + " ");
            }
        }
    }
}
