package com.github.xeolite.enigma.machine;

import com.github.xeolite.enigma.plugboard.Plugboard;
import com.github.xeolite.enigma.reflector.Reflector;
import com.github.xeolite.enigma.reflector.StandardReflector;
import com.github.xeolite.enigma.rotor.RotorGroup;
import com.github.xeolite.enigma.rotor.StandardRotor;
import com.github.xeolite.enigma.stator.Stator;
import com.github.xeolite.enigma.step.LeverGroup;

public class EnigmaM3 extends Enigma {

    public EnigmaM3(StandardReflector reflector, StandardRotor leftRotor, StandardRotor centerRotor, StandardRotor rightRotor, Plugboard plugboard) {
        super(new EnigmaMechanism(reflector, new RotorGroup(leftRotor, centerRotor, rightRotor), new LeverGroup(), Stator.MILITARY, plugboard));
    }
}
