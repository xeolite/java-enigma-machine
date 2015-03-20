package com.github.xeolite.enigma.rotor;

import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.stator.Stator;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StatorTest {

    @Test
    public void enciphersInbound() {
        assertThat(Stator.COMMERCIAL.inbound().encipher(Letter.Q), is(Letter.A));
    }

    @Test
    public void enciphersOutbound() {
        assertThat(Stator.COMMERCIAL.outbound().encipher(Letter.A), is(Letter.Q));
    }
}