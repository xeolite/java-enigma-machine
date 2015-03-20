package com.github.xeolite.enigma.io;

import static java.util.stream.IntStream.range;

import java.util.Iterator;
import java.util.stream.Stream;

public class EnigmaInput implements Iterable<Letter> {

    private String input;

    public EnigmaInput(String input) {
        this.input = input;
    }

    public static Stream<Letter> letters(String s) {
        return new EnigmaInput(s).stream();
    }

    @Override
    public Iterator<Letter> iterator() {
        return stream().iterator();
    }

    public Stream<Letter> stream() {
        return range(0, input.length())
                .mapToObj(input::charAt)
                .filter(Letter::isLetter)
                .map(Letter::valueOf);
    }
}
