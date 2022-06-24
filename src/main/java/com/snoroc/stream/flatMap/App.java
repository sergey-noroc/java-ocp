package com.snoroc.stream.flatMap;

import com.snoroc.stream.model.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//flatMap() is an intermediate operation and return a new Stream.

public class App {

    public static void main(String[] args) {

        getCards().stream()
                .flatMap(card -> card.getCardTransactions().stream())
                .collect(Collectors.toList())
                .forEach(System.out::println);

        getPhones().stream()
                .flatMap(phone -> Stream.of(
                   String.format("name: %s price without sale: %d", phone.getName(), phone.getPrice()),
                   String.format("name: %s price with sale: %d", phone.getName(), phone.getPrice() - (int)(phone.getPrice()*0.1))
                ))
                .forEach(System.out::println);

        BigDecimal sumOfLineItems = getOrders().stream()
                .flatMap(order -> order.getLineItems().stream())
                .map(lineItem -> lineItem.getTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sumOfLineItems);
    }

    private static List<Card> getCards() {
        return List.of(
                new Card("Sergiu Noroc", "1234-1234-1234-1234", 566, 10000, true, TypeCard.VISA,
                        List.of(new CardTransaction("ATM-0", 5000, null),
                                new CardTransaction("ATM-1", 3000, null),
                                new CardTransaction("ATM-2", 1000, null)))
        );
    }

    private static List<Phone> getPhones() {
        return List.of(
                new Phone("Samsung Galaxy", 15000),
                new Phone("iPhone 11", 18000)
        );
    }

    private static List<Order> getOrders() {

        LineItem item1 = new LineItem(1, "apple", 1, new BigDecimal(1.20), new BigDecimal(1.20));
        LineItem item2 = new LineItem(2, "orange", 2, new BigDecimal(".50"), new BigDecimal("1.00"));
        Order order1 = new Order(1, "A0000001", Arrays.asList(item1, item2), new BigDecimal("2.20"));

        LineItem item3 = new LineItem(3, "monitor BenQ", 5, new BigDecimal("99.00"), new BigDecimal("495.00"));
        LineItem item4 = new LineItem(4, "monitor LG", 10, new BigDecimal("120.00"), new BigDecimal("1200.00"));
        Order order2 = new Order(2, "A0000002", Arrays.asList(item3, item4), new BigDecimal("1695.00"));

        LineItem item5 = new LineItem(5, "One Plus 8T", 3, new BigDecimal("499.00"), new BigDecimal("1497.00"));
        Order order3 = new Order(3, "A0000003", Arrays.asList(item5), new BigDecimal("1497.00"));

        return Arrays.asList(order1, order2, order3);
    }
}
