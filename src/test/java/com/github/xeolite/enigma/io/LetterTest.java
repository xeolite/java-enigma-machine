package com.github.xeolite.enigma.io;

import com.github.xeolite.enigma.io.Letter;
import org.junit.Test;

import static com.github.xeolite.enigma.io.Letter.*;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class LetterTest {

    @Test
    public void convertsStringToLetters() {
        assertThat(Letter.valuesOf("aBcDe"), is(arrayContaining(A, B, C, D, E)));
    }

    @Test
    public void addsIntegerToLetter() {
        assertThat(A.plus(2), is(C));
    }

    @Test
    public void addsLetterIndexToLetter() {
        assertThat(B.plus(D), is(E));
    }

    @Test
    public void cyclesAddition() {
        assertThat(Z.plus(1), is(A));
    }

    @Test
    public void subtractsIntegerFromLetter() {
        assertThat(C.minus(2), is(A));
    }

    @Test
    public void subtractsLetterIndexFromLetter() {
        assertThat(E.minus(D), is(B));
    }

    @Test
    public void cyclesSubtraction() {
        assertThat(A.minus(1), is(Z));
    }

    @Test
    public void identifiesLetter() {
        for (char c = 0; c < 256; c++) {
            boolean expected = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
            assertThat(Letter.isLetter(c), is(expected));
        }
    }

}