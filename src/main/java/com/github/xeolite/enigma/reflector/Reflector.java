package com.github.xeolite.enigma.reflector;

import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.cipher.Cipher;
import com.github.xeolite.enigma.cipher.SubstitutionCipher;

public class Reflector implements Cipher {

    private Cipher cipher;

    public Reflector(String alphabet) {
        this.cipher = new SubstitutionCipher(alphabet);
    }

    @Override
    public Letter encipher(Letter letter) {
        return cipher.encipher(letter);
    }

}