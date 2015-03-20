package com.github.xeolite.enigma.rotor;

import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.cipher.Cipher;

public class ThinRotor extends Rotor {
	
	public static final RotorConfiguration<ThinRotor> BETA = new RotorConfiguration<>(ThinRotor::new, "LEYJVCNIXWPBQMDRTAKZGFUHOS");
	public static final RotorConfiguration<ThinRotor> GAMMA = new RotorConfiguration<>(ThinRotor::new, "FSOKANUERHMBTIYCWLQPZXVGJD");
	
	public ThinRotor(Cipher cipher, Letter ringSetting, NotchRing notchRing) {
		super(cipher, ringSetting, notchRing);
	}

	@Override
	public void step() {
		throw new UnsupportedOperationException("Thin rotors cannot be stepped");
	}
	
	
}
