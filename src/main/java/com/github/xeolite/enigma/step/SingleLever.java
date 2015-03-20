package com.github.xeolite.enigma.step;

public class SingleLever extends DualLever {

	public SingleLever(Step ratchetLever) {
		super(ratchetLever);
	}

	@Override
	public SingleLever engageNotch(Step notch) {
		return this;
	}
	
}
