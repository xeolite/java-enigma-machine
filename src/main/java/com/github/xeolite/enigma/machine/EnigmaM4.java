package com.github.xeolite.enigma.machine;

import com.github.xeolite.enigma.plugboard.Plugboard;
import com.github.xeolite.enigma.reflector.ThinReflector;
import com.github.xeolite.enigma.rotor.RotorGroup;
import com.github.xeolite.enigma.rotor.StandardRotor;
import com.github.xeolite.enigma.rotor.ThinRotor;
import com.github.xeolite.enigma.stator.Stator;
import com.github.xeolite.enigma.step.LeverGroup;

public class EnigmaM4 extends Enigma {

    public EnigmaM4(ThinReflector reflector,
                    ThinRotor fourthRotor,
                    StandardRotor leftRotor,
                    StandardRotor centreRotor,
                    StandardRotor rightRotor,
                    Plugboard plugboard) {

        super(new EnigmaMechanism(reflector, new RotorGroup(fourthRotor, leftRotor, centreRotor, rightRotor), new LeverGroup(), Stator.MILITARY, plugboard));
    }



}
