package com.github.xeolite.enigma.cipher;

import org.junit.Test;

import static com.github.xeolite.enigma.io.Letter.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SubstitutionCipherTest {

    private static final String ALPHABET = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";

    @Test
    public void substitutesLetter() {
        SubstitutionCipher substitution = new SubstitutionCipher(ALPHABET);
        assertThat(substitution.encipher(A), is(E));
    }

    @Test
    public void substitutesInverse() {
        Cipher substitution = Cipher.inverse(new SubstitutionCipher(ALPHABET));
        assertThat(substitution.encipher(E), is(A));
    }

}
