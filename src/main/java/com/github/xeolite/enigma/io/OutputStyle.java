package com.github.xeolite.enigma.io;

public interface OutputStyle {

    public static OutputStyle plain() {
        return new OutputStyle() {};
    }

    public static GroupedOutput groupsOf(int size) {
        return new GroupedOutput(plain(), size, ' ');
    }

    default void append(StringBuilder to, Letter letter) {
        to.append(letter);
    }

}
