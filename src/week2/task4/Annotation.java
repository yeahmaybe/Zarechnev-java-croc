package week2.task4;

public class Annotation {

    private final Figure figure;
    private final String text;

    Annotation(Figure figure, String text) {
        this.figure = figure;
        this.text = text;
    }

    @Override
    public String toString() {
        return figure + ": " + text;
    }

}
