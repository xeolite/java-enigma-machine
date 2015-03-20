package com.github.xeolite.enigma.rotor;

import static com.github.xeolite.enigma.io.Letter.E;
import static com.github.xeolite.enigma.io.Letter.J;
import static com.github.xeolite.enigma.io.Letter.M;
import static com.github.xeolite.enigma.io.Letter.Q;
import static com.github.xeolite.enigma.io.Letter.Z;
import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.cipher.Cipher;

public class StandardRotor extends Rotor {

    public static final RotorConfiguration<StandardRotor> I = new RotorConfiguration<>(StandardRotor::new, "EKMFLGDQVZNTOWYHXUSPAIBRCJ", Q);
    public static final RotorConfiguration<StandardRotor> II = new RotorConfiguration<>(StandardRotor::new, "AJDKSIRUXBLHWTMCQGZNPYFVOE", E);
    public static final RotorConfiguration<StandardRotor> III = new RotorConfiguration<>(StandardRotor::new, "BDFHJLCPRTXVZNYEIWGAKMUSQO", Letter.V);
    public static final RotorConfiguration<StandardRotor> IV = new RotorConfiguration<>(StandardRotor::new, "ESOVPZJAYQUIRHXLNFTGKDCMWB", J);
    public static final RotorConfiguration<StandardRotor> V = new RotorConfiguration<>(StandardRotor::new, "VZBRGITYUPSDNHLXAWMJQOFECK", Z);
    public static final RotorConfiguration<StandardRotor> VI = new RotorConfiguration<>(StandardRotor::new, "JPGVOUMFYQBENHZRDKASXLICTW", M, Z);
    public static final RotorConfiguration<StandardRotor> VII = new RotorConfiguration<>(StandardRotor::new, "NZJHGRCXMYSWBOUFAIVLPEKQDT", M, Z);
    public static final RotorConfiguration<StandardRotor> VIII = new RotorConfiguration<>(StandardRotor::new, "FKQHTLXOCBJSPDZRAMEWNIUYGV", M, Z);


    public StandardRotor(Cipher cipher, Letter ringSetting, NotchRing notchRing) {
        super(cipher, ringSetting, notchRing);
    }

}
