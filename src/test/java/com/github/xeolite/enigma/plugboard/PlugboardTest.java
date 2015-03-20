package com.github.xeolite.enigma.plugboard;

import com.github.xeolite.enigma.io.Letter;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PlugboardTest {

    @Test
    public void enciphersConnectedLetters() throws Exception {
        Plugboard plugboard = new Plugboard().connect(Letter.A, Letter.M);

        assertThat(plugboard.encipher(Letter.A), is(Letter.M));
        assertThat(plugboard.encipher(Letter.M), is(Letter.A));
    }

    @Test
    public void doesNotEncipherUnconnectedLetters() throws Exception {
        Plugboard plugboard = new Plugboard().connect(Letter.A, Letter.M);

        assertThat(plugboard.encipher(Letter.B), is(Letter.B));
    }

    @Test
    public void clearsConnections() throws Exception {
        Plugboard plugboard = new Plugboard().connect(Letter.A, Letter.M);

        plugboard.clear();

        assertThat(plugboard.encipher(Letter.A), is(Letter.A));
        assertThat(plugboard.encipher(Letter.M), is(Letter.M));
    }
}