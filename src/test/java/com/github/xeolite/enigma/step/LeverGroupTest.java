package com.github.xeolite.enigma.step;

import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.rotor.RotorGroup;
import com.github.xeolite.enigma.rotor.StandardRotor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LeverGroupTest {
	
	@Test
	public void alwaysStepsRightRotor() {
		RotorGroup rotors = new RotorGroup(
				StandardRotor.III.startAt(Letter.A),
				StandardRotor.II.startAt(Letter.A),
				StandardRotor.I.startAt(Letter.Z)
			);
		new LeverGroup().engage(rotors);;
		
		assertThat(rotors.toString(), is("AAA"));
	}
	
	@Test
	public void stepsRightAndCentreRotors() {
		RotorGroup rotors = new RotorGroup(
				StandardRotor.III.startAt(Letter.A),
				StandardRotor.II.startAt(Letter.A),
				StandardRotor.I.startAt(Letter.Q)
			);
		
		new LeverGroup().engage(rotors);;
		
		assertThat(rotors.toString(), is("ABR"));
	}
	
	@Test
	public void stepsCentreAndLeftRotors() {
		RotorGroup rotors = new RotorGroup(
				StandardRotor.III.startAt(Letter.Z),
				StandardRotor.II.startAt(Letter.E),
				StandardRotor.I.startAt(Letter.A)
				);
		
		new LeverGroup().engage(rotors);;
		
		assertThat(rotors.toString(), is("AFB"));
	}
	
	@Test
	public void stepsThreeRotors() {
		RotorGroup rotors = new RotorGroup(
				StandardRotor.III.startAt(Letter.A),
				StandardRotor.II.startAt(Letter.E),
				StandardRotor.I.startAt(Letter.Q)
			);
		
		new LeverGroup().engage(rotors);;
		
		assertThat(rotors.toString(), is("BFR"));
	}
	
	@Test
	public void doesNotEngageNotchesOfLeftRotor() {
		RotorGroup rotors = new RotorGroup(
				StandardRotor.III.startAt(Letter.V),
				StandardRotor.II.startAt(Letter.A),
				StandardRotor.I.startAt(Letter.A)
			);
		
		new LeverGroup().engage(rotors);;
		
		assertThat(rotors.toString(), is("VAB"));
	}

	@Test
	public void doesNotStepFourthRotor() {
		RotorGroup rotors = new RotorGroup(
				StandardRotor.III.startAt(Letter.A),
				StandardRotor.III.startAt(Letter.V),
				StandardRotor.II.startAt(Letter.C),
				StandardRotor.I.startAt(Letter.A)
			);
		
		new LeverGroup().engage(rotors);;
		
		assertThat(rotors.toString(), is("AVCB"));
	}
	
	@Test
	public void doubleStepsCentreRotor() {
		RotorGroup rotors = new RotorGroup(
				StandardRotor.III.startAt(Letter.A),
				StandardRotor.II.startAt(Letter.D),
				StandardRotor.I.startAt(Letter.Q)
			);
		
		LeverGroup levers = new LeverGroup();
		
		levers.engage(rotors);
		assertThat(rotors.toString(), is("AER"));
		
		levers.engage(rotors);
		assertThat(rotors.toString(), is("BFS"));
	}
	
}
