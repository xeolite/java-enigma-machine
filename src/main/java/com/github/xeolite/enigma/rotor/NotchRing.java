package com.github.xeolite.enigma.rotor;

import static java.util.Arrays.stream;
import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.step.Step;

public class NotchRing {
	
	private Step[] ring;
	
	public NotchRing(Letter... stepPositions) {
		ring = Letter.stream().map(l -> Step.ZERO).toArray(Step[]::new);
		stream(stepPositions).forEach(p -> ring[p.index()] = Step.ONE);
	}
	
	public Step getNotch(Letter position) {
		return ring[position.index()];
	}
	
}
