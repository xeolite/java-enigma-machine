package com.github.xeolite.enigma.step;

import java.util.Iterator;

import com.github.xeolite.enigma.rotor.Rotor;
import com.github.xeolite.enigma.rotor.RotorGroup;

public class LeverGroup {
	
	private int size;

	
	public LeverGroup() {
		this(3);
	}

	public LeverGroup(int size) {
		this.size = size;
	}

	public void engage(RotorGroup rotorGroup) {
		
		Iterator<Rotor> rotors = rotorGroup.rightToLeft().limit(size).iterator();
		
		for (Step ratchetLever = Step.ONE; rotors.hasNext();) {
			Rotor rotor = rotors.next();
			DualLever levers = rotors.hasNext() ? new DualLever(ratchetLever) : new SingleLever(ratchetLever);
			Step notch = rotor.notch();
			levers.engageNotch(notch).engage(rotor);
			ratchetLever = notch;
		}
	}
	
}
