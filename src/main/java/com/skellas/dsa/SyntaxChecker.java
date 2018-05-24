package com.skellas.dsa;

import java.io.Console;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SyntaxChecker {
    private static String CLOSED_JSON_STRING = "{\"key\":\"value\"}";
    private static String OPEN_JSON_STRING = "{\"keys\":{\"key1\":\"val1\", \"key2\":\"val2\"}";
    private static Set<Character> OPEN_JSON_BRACKETS = Stream.of('{', '[').collect(Collectors.toSet());
    private static Set<Character> CLOSED_JSON_BRACKETS = Stream.of('}', ']').collect(Collectors.toSet());

    private static String CLOSED_HTML_STRING = "";
    private static String OPEN_HTML_STRING = "";

    private static Deque<String> stackString = new ArrayDeque<>();

    public static void main(String[] args) {
        testJsonSuperTrusting(CLOSED_JSON_STRING);
        testJsonSuperTrusting(OPEN_JSON_STRING);
    }

    protected static void testJsonSuperTrusting(String testThisString) {
        Deque<Character> stackChar = new ArrayDeque<>();
        testThisString.chars().mapToObj(c -> (char)c)
                .forEach(c -> {
                    if (OPEN_JSON_BRACKETS.contains(c)) stackChar.push(c);
                    if (CLOSED_JSON_BRACKETS.contains(c)) stackChar.pop();
                });
        if (stackChar.isEmpty())
            System.out.println("String was closed properly");
        else
            System.out.println("String was not closed properly.");
    }
}
