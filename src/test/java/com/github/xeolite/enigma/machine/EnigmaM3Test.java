package com.github.xeolite.enigma.machine;

import com.github.xeolite.enigma.io.OutputStyle;
import com.github.xeolite.enigma.plugboard.Plugboard;
import com.github.xeolite.enigma.reflector.StandardReflector;
import com.github.xeolite.enigma.rotor.StandardRotor;
import org.junit.Test;

import static com.github.xeolite.enigma.io.Letter.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EnigmaM3Test {

    @Test
    public void enciphersText() {

        EnigmaM3 enigma = new EnigmaM3(
                StandardReflector.C,
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
                is("ZYXH QZSW QGMJ RLNR KBRJ LNWI KPKU OZTF WDED BBHL ZEMQ TQBH XKBV QDTN VWWJ YKND UWCX CITA RQJS PLJC XJSU HVJC ZTCD BDIJ HPWC JRAZ CSZE IQXH VVEX QPYC MIMD WVNH WUQN IPZE ZXWY ZGFQ GTOX UXYT UJWV JFIV PCQQ EWBX DRAY RVMU OAFX RJQG LRUS RBHR JQ"));

    }

    private static final String SOURCE_TEXT =
            "And on the pedestal these words appear:\n" +
            "'My name is Ozymandias, king of kings:\n" +
            "Look on my works, ye Mighty, and despair!'\n" +
            "Nothing beside remains. Round the decay\n" +
            "Of that colossal wreck, boundless and bare\n" +
            "The lone and level sands stretch far away.";

}
