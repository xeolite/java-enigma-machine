package com.github.xeolite.enigma.io;

public abstract class OutputStyle {

    public static OutputStyle plain() {
        return new OutputStyle() {};
    }

    public static OutputStyle groupsOf(int size) {
        return new OutputStyle() {
            @Override
            public void append(StringBuilder to, Letter letter) {
                if ((to.length() + 1) % (size + 1) == 0) {
                    to.append(' ');
                }
                super.append(to, letter);
            }
        };
    }

    public void append(StringBuilder to, Letter letter) {
        to.append(letter);
    }

}
