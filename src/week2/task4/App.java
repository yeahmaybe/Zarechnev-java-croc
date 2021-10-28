package week2.task4;

public class App {

    public static void main(String[] args) {

        // пример вывода аннотаций для изображения
        Annotation[] annotations = {
                new Annotation(new Circle(new Point(0,5), 3), "1st annotation"),
                new Annotation(new Circle(new Point(4,100), 10), "2nd annotation"),
                new Annotation(new Rectangle(new Point(56,5), new Point(43, 32)), "3rd annotation"),
                new Annotation(new Circle(new Point(100,5), 3), "4th annotation"),
                new Annotation(new Rectangle(new Point(4,9), new Point(3, 32)), "5th annotation")
        };

        AnnotatedImage img = new AnnotatedImage("path", annotations);
        for(Annotation ann: img.getAnnotations()) {
            System.out.println(ann);
        }

    }
}
