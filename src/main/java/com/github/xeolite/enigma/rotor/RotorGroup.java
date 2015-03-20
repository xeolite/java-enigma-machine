package com.github.xeolite.enigma.rotor;

import static java.util.stream.Collectors.joining;
import static java.util.stream.IntStream.range;

import java.util.stream.Stream;

import com.github.xeolite.enigma.io.Letter;

public class RotorGroup {

    private Rotor[] rotors;

    public RotorGroup(Rotor... leftToRight) {
        this.rotors = leftToRight;
    }

    public Stream<Rotor> leftToRight() {
        return Stream.of(rotors);
    }

    public Stream<Rotor> rightToLeft() {
        return range(0, rotors.length).mapToObj(i -> rotors[rotors.length-1-i]);
    }

    public int size() {
        return rotors.length;
    }

    @Override
    public String toString() {
        return leftToRight().map(Rotor::rotation).map(Letter::toString).collect(joining());
    }
}
