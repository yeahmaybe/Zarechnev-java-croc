package week2.task5;

class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(int x, int y) {
        for(Annotation ann: annotations) {
            if(ann.getFigure().contains(new Point(x,y))) {
                return ann;
            }
        }
        return null;
    }

    public Annotation findByLabel(String label) {
        for(Annotation ann: annotations) {
            if(ann.getLabel().contains(label))
                return ann;
        }
        return null;
    }
}

