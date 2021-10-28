package week3.task6;

public class Main {
    public static void main(String[] args) {
        String source = getCodeSample(); // test data
        String noComments = removeJavaComments(source);
        System.out.println(noComments);
    }

    static String removeJavaComments(String source) {
        String result = source;
        result = result.replaceAll("/\\*([\\W\\w]*?)\\*/", "");
        result = result.replaceAll("//.*+", "");

        return result;
    }

    static String getCodeSample() {
        return  "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "  \n" +
                "  /* main method */\n" +
                "  public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "    // this line prints my first greeting to the screen\n" +
                "    System.out.println(\"Hi!\"); // :)\n" +
                "  }\n" +
                "} // the end\n" +
                "// to be continued...\n";
    }
};


