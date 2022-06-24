package com.snoroc.stream.comparator;

import java.util.*;

public class App {

    public static void main(String[] args) {

        List<User> users = getUsers();

        users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .forEach(user -> System.out.println(user));
    }

    private static List<User> getUsers() {
        return Arrays.asList(
                new User("Sergiu Noroc", 36),
                new User("Mihai Vozian", 34),
                new User("Dumitru Cazacu", 26),
                new User("Sergiu Motpan", 33),
                new User("Alexandr Reznic", 25)
        );
    }
}
