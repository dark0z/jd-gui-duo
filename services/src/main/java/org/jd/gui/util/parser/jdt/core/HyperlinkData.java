package org.jd.gui.util.parser.jdt.core;

public class HyperlinkData {

    private final int startPosition;
    private final int endPosition;

    public HyperlinkData(int startPosition, int endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }
}