package com.github.xeolite.enigma.step;

import com.github.xeolite.enigma.rotor.Rotor;


public class DualLever {

    private Step ratchetLever;
    private Step notchLever;

    public DualLever(Step ratchetLever) {
        this.ratchetLever = ratchetLever;
        this.notchLever = Step.ZERO;
    }

    public DualLever engageNotch(Step notch) {
        this.notchLever = notch;
        return this;
    }

    public void engage(Rotor rotor) {
        ratchetLever.pairedWith(notchLever).engage(rotor);
    }
}
