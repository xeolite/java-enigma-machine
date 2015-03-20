package com.github.xeolite.enigma.cipher;

import com.github.xeolite.enigma.io.Letter;

public interface Cipher {
	
	Letter encipher(Letter letter);

    static Cipher inverse(Cipher cipher) {
        Letter[] inverse = new Letter[Letter.size()];
        Letter.stream().forEach(l -> {inverse[cipher.encipher(l).index()] = l;});
        return new SubstitutionCipher(inverse);
    };
}
