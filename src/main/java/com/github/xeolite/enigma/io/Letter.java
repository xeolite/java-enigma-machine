package com.github.xeolite.enigma.io;

import java.util.regex.Pattern;
import java.util.stream.Stream;



public enum Letter {

    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;

    private static Pattern IS_LETTER = Pattern.compile("[A-Za-z]");

    public static Letter[] valuesOf(String s) {
        return s.chars().mapToObj(i -> Letter.valueOf((char)i)).toArray(Letter[]::new);
    }

    public static Letter valueOf(char c) {
        return valueOf(String.valueOf(c).toUpperCase());
    }

    public int index() {
        return ordinal();
    }

    public static Letter forIndex(int index) {
        return values()[index];
    }

    public static int size() {
        return values().length;
    }

    public Letter plus(int offset) {
        return forIndex((ordinal() + offset + size()) % size());
    }

    public Letter plus(Letter offset) {
        return plus(offset.index());
    }

    public Letter minus(int offset) {
        return plus(-offset);
    }

    public Letter minus(Letter offset) {
        return minus(offset.index());
    }

    public static Stream<Letter> stream() {
        return Stream.of(values());
    }

    public static boolean isLetter(char c) {
        return IS_LETTER.matcher(String.valueOf(c)).matches();
    }

}
