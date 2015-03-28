package com.github.xeolite.enigma.rotor;

import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.cipher.SubstitutionCipher;

public class RotorConfiguration<R extends Rotor> {

    private final String alphabet;
    private final Letter ringSetting;
    private final NotchRing notchRing;
    private final RotorFactory<R> factory;

    public RotorConfiguration(RotorFactory<R> factory, String alphabet, Letter... notchPositions) {
        this(factory, alphabet, Letter.A, new NotchRing(notchPositions));
    }

    private RotorConfiguration(RotorFactory<R> factory, String alphabet, Letter ringSetting, NotchRing notchRing) {
        this.factory = factory;
        this.alphabet = alphabet;
        this.notchRing = notchRing;
        this.ringSetting = ringSetting;
    }

    public RotorConfiguration<R> withSetting(Letter setting) {
        return new RotorConfiguration<R>(factory, alphabet, setting, notchRing);
    }

    public RotorConfiguration<R> withSetting(int setting) {
        return withSetting(Letter.forIndex(setting-1));
    }

    public R startAt(Letter position) {
        R rotor = factory.create(new SubstitutionCipher(alphabet), ringSetting, notchRing);
        rotor.setRotation(position);
        return rotor;
    }

}
