package com.github.xeolite.enigma.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GroupedOutputTest {

    @Test
    public void createsGroupedOutput() {
        OutputStyle outputStyle = new GroupedOutput(OutputStyle.plain(), 3, ' ');
        StringBuilder out = new StringBuilder();

        for (Letter letter : Letter.valuesOf("ABCDEFGHIJK")) {
            outputStyle.append(out, letter);
        }

        assertThat(out.toString(), is("ABC DEF GHI JK"));
    }

    @Test
    public void createsFixedWidthOutput() {
        OutputStyle outputStyle = new GroupedOutput(OutputStyle.plain(), 2, ' ').groupsPerLine(3);
        StringBuilder out = new StringBuilder();

        for (Letter letter : Letter.valuesOf("ABCDEFGHIJK")) {
            outputStyle.append(out, letter);
        }

        assertThat(out.toString(), is("AB CD EF\nGH IJ K"));
    }
}