package com.company;
public class Element {

    private int value;
    private int startPosition;
    private int endPosition;

    public Element(int value, int startPosition) {
        this.value = value;
        this.startPosition = startPosition;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value=" + value +
                ", startPosition=" + startPosition +
                ", endPosition=" + endPosition +
                '}';
    }
}
