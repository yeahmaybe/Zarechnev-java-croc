package ru.croc.task5;

public class Annotation {

    private final Movable figure;
    private final String text;

    Annotation(Figure figure, String text) {
        this.figure = figure;
        this.text = text;
    }

    @Override
    public String toString() {
        return figure + ": " + text;
    }

    public String getLabel() {
        return text;
    }

    public Movable getFigure() {
        return figure;
    }

}
