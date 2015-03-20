package com.github.xeolite.enigma.machine;

import static com.github.xeolite.enigma.io.EnigmaInput.letters;
import static com.github.xeolite.enigma.support.SequentialOnly.sequentially;

import java.util.ArrayList;
import java.util.List;

import com.github.xeolite.enigma.cipher.Cipher;
import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.io.OutputStyle;
import com.github.xeolite.enigma.plugboard.Plugboard;
import com.github.xeolite.enigma.reflector.Reflector;
import com.github.xeolite.enigma.rotor.RotorGroup;
import com.github.xeolite.enigma.stator.Stator;
import com.github.xeolite.enigma.step.LeverGroup;

public class EnigmaMechanism implements Cipher {
	
	private List<Cipher> cipherPath;
	private RotorGroup rotors;
	private LeverGroup levers;

    public EnigmaMechanism(Reflector reflector, RotorGroup rotors, LeverGroup levers, Stator stator, Plugboard plugboard) {
		this.rotors = rotors;
		this.levers = levers;
        this.cipherPath = new ArrayList<>();
		
		cipherPath.add(plugboard);
		cipherPath.add(stator.inbound());
		rotors.rightToLeft().map(r -> r.inbound()).forEach(cipherPath::add);
		cipherPath.add(reflector);
		rotors.leftToRight().map(r -> r.outbound()).forEach(cipherPath::add);
		cipherPath.add(stator.outbound());
		cipherPath.add(plugboard);
	}

	@Override
	public Letter encipher(Letter letter) {
		levers.engage(rotors);
		return cipherPath.stream().reduce(letter, (l,c) -> c.encipher(l), sequentially());
	}
	
	public String encipher(String input, OutputStyle format) {
		return letters(input).map(this::encipher).collect(StringBuilder::new, (b,c) -> format.append(b,c), sequentially()).toString();
	}
	
	public String encipher(String input) {
		return encipher(input, OutputStyle.plain());
	}
}
