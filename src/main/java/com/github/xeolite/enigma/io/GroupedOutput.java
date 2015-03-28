package com.github.xeolite.enigma.io;

public class GroupedOutput implements OutputStyle {

    private OutputStyle modified;
    private int groupSize;
    private char delimiter;

    public GroupedOutput(OutputStyle modified, int groupSize, char delimiter) {
        this.modified = modified;
        this.groupSize = groupSize;
        this.delimiter = delimiter;
    }

    public OutputStyle groupsPerLine(int perLine) {
        return new GroupedOutput(this, (groupSize * perLine) + perLine - 1, '\n');
    }

    @Override
    public void append(StringBuilder to, Letter letter) {
        if ((to.length() + 1) % (groupSize + 1) == 0) {
            to.append(delimiter);
        }
        modified.append(to, letter);
    }
}
