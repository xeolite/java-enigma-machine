package com.github.xeolite.enigma.rotor;

import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.step.Step;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RotorConfigurationTest {
	
	@Test
	public void configuresRingSetting() {
        RotorConfiguration configuration = new RotorConfiguration(StandardRotor::new, "STCDEFGHIJKLMNOPQRBAUVWXYZ");
        Rotor rotor = configuration.withSetting(Letter.B).startAt(Letter.A);
        assertThat(rotor.inbound().encipher(Letter.C), is(Letter.U));
    }

    @Test
    public void configuresStartPosition() {
        RotorConfiguration configuration = new RotorConfiguration(StandardRotor::new, "STCDEFGHIJKLMNOPQRBAUVWXYZ");
        Rotor rotor = configuration.withSetting(Letter.A).startAt(Letter.M);
        assertThat(rotor.rotation(), is(Letter.M));
    }

    @Test
    public void configuresNotches() {
        RotorConfiguration configuration = new RotorConfiguration(StandardRotor::new, "STCDEFGHIJKLMNOPQRBAUVWXYZ", Letter.C);
        Rotor rotor = configuration.withSetting(Letter.A).startAt(Letter.C);
        assertThat(rotor.notch(), is(Step.ONE));
    }

}
