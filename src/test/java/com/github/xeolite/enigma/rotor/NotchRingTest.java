package com.github.xeolite.enigma.rotor;

import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.step.Step;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;

public class NotchRingTest {

    @Test
    public void hasTurnoverAtDefinedPositions() throws Exception {

        NotchRing ring = new NotchRing(Letter.B, Letter.D);

        assertThat(ring.getNotch(Letter.B), Matchers.is(Step.ONE));
        assertThat(ring.getNotch(Letter.D), Matchers.is(Step.ONE));
    }

    @Test
    public void doesNotHaveTurnoverNotchInUndefinedPositions() throws Exception {

        NotchRing ring = new NotchRing(Letter.B, Letter.D);

        assertThat(ring.getNotch(Letter.A), Matchers.is(Step.ZERO));
        assertThat(ring.getNotch(Letter.C), Matchers.is(Step.ZERO));
    }

}