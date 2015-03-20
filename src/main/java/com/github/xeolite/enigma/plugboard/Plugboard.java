package com.github.xeolite.enigma.plugboard;

import java.util.stream.Stream;

import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.cipher.Cipher;

public class Plugboard implements Cipher {

    private Letter[] board;

    public Plugboard() {
        clear();
    }

    public Plugboard connect(Letter from, Letter to) {
        swap(from, to);
        return this;
    }

    @Override
    public Letter encipher(Letter letter) {
        return board[letter.index()];
    }

    public void clear() {
        this.board = Stream.of(Letter.values()).toArray(Letter[]::new);
    }

    private void swap(Letter from, Letter to) {
        if (from.equals(to)) {
            throw new IllegalArgumentException(String.format("Cannot connect position %s to itself", from));
        }
        checkFree(from, to);
        board[from.index()] = to;
        board[to.index()] = from;
    }

    private void checkFree(Letter... positions) {
        for (Letter position : positions) {
            if(!board[position.index()].equals(position)) {
                throw new IllegalStateException(String.format("Position %s is already connected", position.toString()));
            }
        }
    }

}
