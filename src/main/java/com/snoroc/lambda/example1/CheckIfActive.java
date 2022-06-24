package com.snoroc.lambda.example1;

public class CheckIfActive implements CheckFeature {
    @Override
    public boolean test(Card card) {
        return card.active();
    }
}
