package com.snoroc.stream.example1;

public class Card {

    private final String owner;
    private final int balance;
    private final boolean active;
    private final CardType cardType;

    public Card(String owner, int balance, boolean active, CardType cardType) {
        this.owner = owner;
        this.balance = balance;
        this.active = active;
        this.cardType = cardType;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public CardType getCardType() {
        return cardType;
    }

    @Override
    public String toString() {
        return "Card{" +
                "owner='" + owner + '\'' +
                ", balance=" + balance +
                ", active=" + active +
                ", cardType=" + cardType +
                '}';
    }
}
