package com.github.xeolite.enigma.io;

import org.junit.Test;

import static java.util.Arrays.stream;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OutputStyleTest {

    @Test
    public void createsPlainOutput() {
        OutputStyle outputStyle = OutputStyle.plain();
        StringBuilder out = new StringBuilder();

        for (Letter letter : Letter.valuesOf("ABCDEFGHIJK")) {
            outputStyle.append(out, letter);
        }

        assertThat(out.toString(), is("ABCDEFGHIJK"));
    }

}