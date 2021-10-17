package ru.croc.task5;

public class App {

    public static void main(String[] args) {

        // пример поиска аннотаций и их сдвига
        Annotation[] annotations = {
                new Annotation(new Circle(new Point(0,5), 3), "1st annotation"),
                new Annotation(new Circle(new Point(4,100), 10), "2nd annotation"),
                new Annotation(new Rectangle(new Point(43,5), new Point(56, 32)), "3rd annotation"),
                new Annotation(new Circle(new Point(100,5), 3), "4th annotation"),
                new Annotation(new Rectangle(new Point(1,9), new Point(3, 32)), "5th annotation")
        };

        AnnotatedImage img = new AnnotatedImage("path", annotations);

        Annotation ann1 = img.findByLabel("1st");
        if(ann1 != null) {
            System.out.println(ann1);
            ann1.getFigure().move(30, -100);
            System.out.println(ann1);
        }

        Annotation ann2 = img.findByPoint(50, 30);
        if(ann2 != null) {
            System.out.println(ann2);
            ann2.getFigure().move(30, -100);
            System.out.println(ann2);
        }
    }
}
