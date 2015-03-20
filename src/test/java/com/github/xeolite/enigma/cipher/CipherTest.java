package com.github.xeolite.enigma.cipher;

import org.junit.Test;

import static com.github.xeolite.enigma.io.Letter.A;
import static com.github.xeolite.enigma.io.Letter.E;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CipherTest {

    private static final String ALPHABET = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";

    @Test
    public void invertsCipher() {
        Cipher substitution = Cipher.inverse(new SubstitutionCipher(ALPHABET));
        assertThat(substitution.encipher(E), is(A));
    }

}
