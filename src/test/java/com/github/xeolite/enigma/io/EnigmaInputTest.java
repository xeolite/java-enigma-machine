package com.github.xeolite.enigma.io;

import org.junit.Test;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class EnigmaInputTest {

    @Test
    public void filtersLetters()  {
        final Letter[] aToL = Letter.stream().limit(13).toArray(Letter[]::new);

        assertThat(new EnigmaInput("aBc de.-fg=hi/Jk ?>lm"), contains(aToL));
    }
}