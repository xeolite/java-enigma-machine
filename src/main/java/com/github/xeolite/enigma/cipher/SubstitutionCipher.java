package com.github.xeolite.enigma.cipher;

import static java.util.Arrays.stream;
import com.github.xeolite.enigma.io.Letter;

public class SubstitutionCipher implements Cipher {

    private Letter[] alphabet;

    public SubstitutionCipher(String alphabet) {
        this(Letter.valuesOf(alphabet));
    }

    public SubstitutionCipher(Letter[] alphabet) {
        this.alphabet = stream(alphabet).toArray(Letter[]::new);
    }

    @Override
    public Letter encipher(Letter in) {
        return alphabet[in.index()];
    }

}
