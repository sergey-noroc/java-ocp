package com.snoroc.java17;

public class AppMatchingAndNull {

    public static void main(String[] args) {
        testStringJava17("Java 16");
        testStringJava17("Java 11");
        testStringJava17("");
        testStringJava17(null);
    }

    private static void testStringOld(String s) {
        if(s == null) {
            System.out.println("Unknown");
            return;
        }

        switch (s) {
            case "Java 11", "Java 17" -> System.out.println("LTS");
            default -> System.out.println("Ok");
        }
    }

    private static void testStringJava17(String s) {
        switch (s) {
            case null                   -> System.out.println("Unknown!");
            case "Java 11", "Java 17"   -> System.out.println("LTS");
            default                     -> System.out.println("Ok");
        }
    }
}
