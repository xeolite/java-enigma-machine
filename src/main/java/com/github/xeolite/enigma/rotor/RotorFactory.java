package com.github.xeolite.enigma.rotor;

import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.cipher.Cipher;

@FunctionalInterface
public interface RotorFactory<R extends Rotor> {

    R create(Cipher cipher, Letter ringSetting, NotchRing notchRing);

}
