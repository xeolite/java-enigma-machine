package com.github.xeolite.enigma.rotor;

import com.github.xeolite.enigma.io.Letter;
import com.github.xeolite.enigma.cipher.Cipher;
import com.github.xeolite.enigma.step.Step;

public class Rotor {
	
	private final Cipher inboundCipher;
	private final Cipher outboundCipher;
	private final NotchRing notchRing;
    private final Letter ringSetting;
	private Letter rotation;
	
	public Rotor(Cipher cipher, Letter ringSetting, NotchRing notchRing) {
		this.inboundCipher = cipher;
        this.ringSetting = ringSetting;
        this.outboundCipher = Cipher.inverse(cipher);
		this.rotation = Letter.A;
		this.notchRing = notchRing;
	}
	
	public Rotor setRotation(Letter position) {
		this.rotation = position;
		return this;
	}
	
	public Cipher outbound() {
        return adjusted(outboundCipher);
    }

    public Cipher inbound() {
		return adjusted(inboundCipher);
	}

    private Cipher adjusted(Cipher cipher) {
        return new Cipher() {
            @Override
            public Letter encipher(Letter letter) {
                return cipher.encipher(letter.plus(rotation).minus(ringSetting))
                        .minus(rotation).plus(ringSetting);
            }
        };
    }

    public void step() {
		this.rotation = this.rotation.plus(1);
	}
	
	public Step notch() {
		return notchRing.getNotch(this.rotation);
	}
	
	public Letter rotation() {
		return rotation;
	}
	
}
