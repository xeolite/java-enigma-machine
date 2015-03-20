package com.github.xeolite.enigma.machine;

import com.github.xeolite.enigma.io.OutputStyle;
import com.github.xeolite.enigma.plugboard.Plugboard;
import com.github.xeolite.enigma.reflector.ThinReflector;
import com.github.xeolite.enigma.rotor.StandardRotor;
import com.github.xeolite.enigma.rotor.ThinRotor;
import org.junit.Test;

import static com.github.xeolite.enigma.io.Letter.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EnigmaM4Test {

    @Test
    public void enciphersText() {

        Enigma enigma = new EnigmaM4(
                ThinReflector.C_THIN,
                ThinRotor.GAMMA.withSetting(X).startAt(S),
                StandardRotor.I.withSetting(M).startAt(P),
                StandardRotor.II.withSetting(J).startAt(D),
                StandardRotor.III.withSetting(H).startAt(T),
                new Plugboard()
                        .connect(A, U)
                        .connect(F, O)
                        .connect(K, R)
                        .connect(I, S)
                        .connect(D, P)
                        .connect(X, W)
        );

        assertThat(enigma.encipher(SOURCE_TEXT, OutputStyle.groupsOf(4)),
                is("RGEK LMWD HZZX QJLK DZOQ OEZK NYHN QVNG KHUG CWAK NRFN PZVS SQNB JFIK EZYR CDSC HGMA LGVC NTRN SCMU VHQL KNZA FVPI CWKB PWSS AXQW RPFH TBDB MDWC TJRJ QSPP GQAP PGAB QARJ IDVD QHDL ICPI KSMY DDSL EOCW RSUT SCHC FGQX SNSP KMHZ UWBM PUYK KNOC WC"));

    }

    private static final String SOURCE_TEXT =
                    "And on the pedestal these words appear:\n" +
                    "'My name is Ozymandias, king of kings:\n" +
                    "Look on my works, ye Mighty, and despair!'\n" +
                    "Nothing beside remains. Round the decay\n" +
                    "Of that colossal wreck, boundless and bare\n" +
                    "The lone and level sands stretch far away.";

}
