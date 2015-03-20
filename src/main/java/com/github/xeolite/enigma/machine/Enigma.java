package com.github.xeolite.enigma.machine;

import com.github.xeolite.enigma.cipher.Cipher;
import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.io.OutputStyle;

public abstract class Enigma implements Cipher {

	private EnigmaMechanism mechanism;

	protected Enigma(EnigmaMechanism mechanism) {
		this.mechanism = mechanism;
	}

	@Override
	public Letter encipher(Letter letter) {
		return mechanism.encipher(letter);
	}

	public String encipher(String input) {
		return mechanism.encipher(input);
	}

	public String encipher(String input, OutputStyle format) {
		return mechanism.encipher(input, format);
	}

}