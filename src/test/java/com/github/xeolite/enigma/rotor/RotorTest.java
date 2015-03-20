package com.github.xeolite.enigma.rotor;

import com.github.xeolite.enigma.cipher.Cipher;
import com.github.xeolite.enigma.cipher.SubstitutionCipher;
import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.step.Step;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RotorTest {

    private static final Cipher CIPHER = new SubstitutionCipher("KRNDEFGCIZWYMBOPQJHTUVAXLS");

	@Test
	public void enciphersInbound() {
        Rotor rotor = new Rotor(CIPHER, Letter.A, new NotchRing());
        assertThat(rotor.inbound().encipher(Letter.A), is(Letter.K));
    }

    @Test
	public void enciphersInboundWithRotation()  {
        Rotor rotor = new Rotor(CIPHER, Letter.A, new NotchRing());
		rotor.setRotation(Letter.B);
		assertThat(rotor.inbound().encipher(Letter.A), is(Letter.Q));
	}

    @Test
    public void enciphersInboundWithSetting()  {
        Rotor rotor = new Rotor(CIPHER, Letter.B, new NotchRing());
        assertThat(rotor.inbound().encipher(Letter.A), is(Letter.T));
    }

    @Test
    public void enciphersInboundWithSettingAndRotation()  {
        Rotor rotor = new Rotor(CIPHER, Letter.B, new NotchRing());
        rotor.setRotation(Letter.B);
        assertThat(rotor.inbound().encipher(Letter.A), is(Letter.K));
    }

    @Test
	public void enciphersOutbound()  {
        Rotor rotor = new Rotor(CIPHER, Letter.A, new NotchRing());
		assertThat(rotor.outbound().encipher(Letter.R), is(Letter.B));
	}
	
	@Test
	public void enciphersOutboundWithRotation()  {
        Rotor rotor = new Rotor(CIPHER, Letter.A, new NotchRing());
		rotor.setRotation(Letter.B);
		assertThat(rotor.outbound().encipher(Letter.R), is(Letter.Y));
	}

    @Test
    public void enciphersOutboundWithSetting()  {
        Rotor rotor = new Rotor(CIPHER, Letter.B, new NotchRing());
        assertThat(rotor.outbound().encipher(Letter.S), is(Letter.C));
    }

    @Test
    public void enciphersOutboundWithSettingAndRotation()  {
        Rotor rotor = new Rotor(CIPHER, Letter.B, new NotchRing());
        rotor.setRotation(Letter.B);
        assertThat(rotor.outbound().encipher(Letter.R), is(Letter.B));
    }

    @Test
    public void returnsNotchAtCurrentPosition() throws Exception {
        Rotor rotor = new Rotor(CIPHER, Letter.A, new NotchRing(Letter.B));
        assertThat(rotor.notch(), is(Step.ZERO));

        rotor.setRotation(Letter.B);

        assertThat(rotor.notch(), is(Step.ONE));
    }

    @Test
    public void stepsByOnePosition() throws Exception {
        Rotor rotor = new Rotor(CIPHER, Letter.A, new NotchRing());
        rotor.setRotation(Letter.C);

        rotor.step();

        assertThat(rotor.rotation(), is(Letter.D));
    }

}
